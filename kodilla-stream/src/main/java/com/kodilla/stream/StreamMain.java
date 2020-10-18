package com.kodilla.stream;


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> resultMap = forum.getForumUsers().stream()
                .filter(s -> s.getSex() == 'M')
                .filter(age -> ChronoUnit.YEARS.between(age.getDateOfBirth(), LocalDate.now()) >= 20)
                .filter(posts -> posts.getPostsNumber() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        System.out.println("Result Map:");
        resultMap.entrySet()
                .forEach(System.out::println);
// ----------- Koniec zadania - poniższy (zakomentowany) kod służy jedynie do powtórek -------------


/*
// ------------------------ Operacje terminalne - kolektory -------------------------------------

        // ---------------------- .forEach() --------------------------
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        System.out.println();
        // ------------------ .collect(Collectors.toList()) ---------------------
        // tworzy kolekcję w postaci listy
        BookDirectory theBookDirectory2 = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory2.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("List # elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        System.out.println();
        // ------------------ .collect(Collectors.toMap()) ----------------------
        // tworzy kolekcję w postaci mapy
        // Collectors.toMap(Function keyMapper, Function valueMapper)
        BookDirectory theBookDirectory3 = new BookDirectory();

        Map<String, Book> theResultMapOfBooks2 = theBookDirectory3.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("Map # elements: " + theResultMapOfBooks2.size());
        theResultMapOfBooks2.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println();
        // ------------------ .collect(Collectors.joining()) --------------------
        // tworzy String zawierający teksty  reprezentujące poszczególne obiekty oddzielone wskazanym separatorem
        // Collectors.joining(String delimiter, String prefix, String suffix)
        // delimiter - oddzieli poszczególe obiekty
        // prefix - wynikowy ciąg znaków będzie tym poprzedzony
        // suffix - wynikowy ciąg znaków będzie tym zakończony
        BookDirectory theBookDirectory4 = new BookDirectory();
        String theResultStringOfBooks3 = theBookDirectory4.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println("Collectors.joining() result:");
        System.out.println(theResultStringOfBooks3);
 */

/*

        People.getList().stream()
                .forEach(System.out::println);

        System.out.println();

        People.getList().stream()
                .map(s -> s.toUpperCase())          //map(Function mapper), gdzie mapper jest wyrażeniem lambda otrzymującym jeden argument wejściowy
                .forEach(System.out::println);
//    ------ Lub równoważnie można zapisać to też w tem sposób
//        People.getList().stream()
//                .map(String::toUpperCase)
//                .forEach(s -> System.out.println(s));

        System.out.println();

        //wybieramy elementy dłuższe niż 11 znaków
        System.out.println("Names longer than 11 chars:");
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);

        //kaskadowe łączenie operacji na Stream
        System.out.println("\nKaskadowe łązenie operacji na Stream");
        People.getList().stream()
                .map(String::toUpperCase)                               // konwertuje wszystkie nazwiska i imiona na wielkie litery
                .filter(s -> s.length() > 11)                           // wybierze spośród nich te, których długość jest większa niż 11 znaków
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")     // usunie nazwiska pozostawiając jedynie pierwszą ich literę, a resztę zastąpi kropką
                .filter(s -> s.substring(0, 1).equals("M"))             // odfiltruje tylko te obiekty, dla których pierwszą literą imienia jest "M"
                .forEach(System.out::println);                          // wynik wyświetli na ekranie
*/

/*// ------------------- Dalszą częśc zostawiłem do powtórek materiału -----------------------
        System.out.println();
        System.out.println("Module 7 - Stream");

        // ------------------------- WYRAŻENIA LAMBDA BEZ ARGUMENTÓW ---------------------
        //Podejście OOP (obiektowe)
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        //Daje możliwość używania intejfejsów
        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        //Podejście funkcyjne
        //Możemy używać interfejsu z użyciem wyrażenie lambda
        //dzięki temu nie musimy tworzyć obiektu ExecuteSaySomething
        //do zmiennej codeToExecute zapisujemy nie wartość ale kod do wykonania
        Processor processor1 = new Processor();
        Executor codeToExecute = () -> System.out.println("Example text from lambda expression.");
        processor1.execute(codeToExecute);

        //Jeszcze uproszczając - możemy zapisać jako
        Processor processor2 = new Processor();
        processor2.execute(() -> System.out.println("Example text2 from lambda expression."));
        // ----------------------------------------------------------------------------------

        System.out.println();

        // ---------------------- WYRAŻENIA LAMBDA Z ARGUMENTAMI ----------------------------
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calcutations with lambda expressions");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        // Jeżeli w wyrażeniu lambda jest tylko jeden argument to nie piszemy nawiasów

        // ----- przy użyciu METHOD REFERENCE (referencji do metod) --------
        // wyglądało by to tak: mamy już klasę (FunctionalCalculator)
        // która ma metody (statyczne) z kodem który chcemy użyć
        // method reference dla metod statycznych klasy wygląda tak: ClassName::methodName
        // method reference dla metod istniejącego obiektu wygląda tak: object::methodName
        // method reference dla metod konstruktora klasy wygląda tak: ClassName::new

        System.out.println("Calculations with method references");
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::divideAByB);

        // ---------------------Trening wyrażeń lambda ----------------------
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("teXt dO uPięKszeNia", text -> text.toUpperCase());
        poemBeautifier.beautify("teXt dO uPięKszeNia", String::toUpperCase);
        poemBeautifier.beautify("teXt dO uPięKszeNia", text -> "To jest piekniejsza wersja napisu: " + text);
        poemBeautifier.beautify("bArdzo BrzyDKI tExT", text -> "Piękny tekst: " + text.toLowerCase());
        poemBeautifier.beautify("bArdzo BrzyDKI tExT", text -> "ABC " + text.toLowerCase() + " CDE");

//------------------------------------------------------------------------------------------------

        // ----------------------------- interfejs STREAM ----------------------------------
        // użycie znajdziesz w pakiecie com.kodilla.stream.immutable
        System.out.println();
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
        //----------------------------------------------------------------------------------*/
    }
}
