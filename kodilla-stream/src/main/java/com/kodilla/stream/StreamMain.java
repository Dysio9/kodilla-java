package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("teXt dO uPięKszeNia", text -> text.toUpperCase());
        poemBeautifier.beautify("teXt dO uPięKszeNia", String::toUpperCase);
        poemBeautifier.beautify("teXt dO uPięKszeNia", text -> "To jest piekniejsza wersja napisu: " + text);
        poemBeautifier.beautify("bArdzo BrzyDKI tExT", text -> "Piękny tekst: " + text.toLowerCase());
        poemBeautifier.beautify("bArdzo BrzyDKI tExT", text -> "ABC " + text.toLowerCase() + " CDE");



// ------------ Dalszą częśc zostawiłem do powtórek materiału, nie jest częścią zadania -----
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




        //----------------------------------------------------------------------------------
    }
}
