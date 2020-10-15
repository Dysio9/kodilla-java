package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @InjectMocks
    private BookLibrary bookLibrary;
    LibraryUser libraryUser;

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksWithConditionsReturnList() {
        // Given
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());

    }

    @ParameterizedTest
    @CsvSource({"ZeroBooks,0,0", "Any title,15,15", "FortyBooks,40,0"})
    void testListBooksWithConditionMoreThan20(String bookName, int booksInBase, int expected) {
        // Given
        List<Book> resultListOfBooks = generateListOfNBooks(booksInBase);
        when(libraryDatabaseMock.listBooksWithCondition(bookName))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition(bookName);

        // Then
        assertEquals(expected, theListOfBooks.size());
    }


    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());

    }

    @Test
    void testListBooksInHandsOfWithoutAnyBooks() {
        //Given
        List<Book> booksInHandsList = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser))
                .thenReturn(booksInHandsList);

        //When
        List<Book> booksInHandsList0 = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(0, booksInHandsList0.size());
    }

    @Test
    void testListBooksInHandsOfWithOnlyOneBook() {
        //Given
        List<Book> booksInHandsList = new ArrayList<>();
        booksInHandsList.add(new Book("Kubuś Puchatek","A.A.Milne",2001));
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser))
                .thenReturn(booksInHandsList);

        //When
        List<Book> booksInHandsList1 = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(1, booksInHandsList1.size());
    }

    @Test
    void testListBooksInHandsOfWithFiveBooks() {
        //Given
        List<Book> booksInHandsList = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser))
                .thenReturn(booksInHandsList);

        //When
        List<Book> booksInHandsList5 = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(5, booksInHandsList5.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}