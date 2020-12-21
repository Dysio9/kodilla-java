package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testShallowCopy() {
        //Given
        Set<Book> books = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            books.add(new Book("title" + i, "author" + i, LocalDate.ofYearDay(2020, i)));
        }
        Library library = new Library("First Library");
        library.setBooks(books);

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowClone();
            shallowClonedLibrary.setName("ShallowClonedLibrary");
        } catch (CloneNotSupportedException e) {
            System.out.println("Error: " + e);
        }

        //When
        shallowClonedLibrary.getBooks().remove(new Book("title2", "author2", LocalDate.ofYearDay(2020,2)));
        System.out.println(library);
        System.out.println(shallowClonedLibrary);

        //Then
        assertEquals(4, library.getBooks().size());
        assertEquals(4, shallowClonedLibrary.getBooks().size());
    }

    @Test
    void testDeepCopy() {
        //Given
        Set<Book> books = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            books.add(new Book("title" + i, "author" + i, LocalDate.ofYearDay(2020, i)));
        }
        Library library = new Library("First Library");
        library.setBooks(books);

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepClone();
            deepClonedLibrary.setName("DeepClonedLibrary");
        } catch (CloneNotSupportedException e) {
            System.out.println("Error: " + e);
        }

        //When
        deepClonedLibrary.getBooks().remove(new Book("title2", "author2", LocalDate.ofYearDay(2020,2)));
        System.out.println(library);
        System.out.println(deepClonedLibrary);

        //Then
        assertEquals(5, library.getBooks().size());
        assertEquals(4, deepClonedLibrary.getBooks().size());
    }

}
