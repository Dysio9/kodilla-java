package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Library {

    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public Library(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    // -------- Wstrzykiwanie zależności właściwości klasy ----------
//    @Autowired
//    private LibraryDbController libraryDbController;
//
// --------- Wstrzykiwanie zależności przez konstruktor ---------
//    @Autowired
//    public Library(final LibraryDbController libraryDbController) {
//        this.libraryDbController = libraryDbController;
//    }
//
// ---------- Wstrzykiwanie zależnosni przez metodę -------------
//    @Autowired
//    public void setLibraryDbController(LibraryDbController libraryDbController) {
//        this.libraryDbController = libraryDbController;
//    }

// --- ten konstruktor nie jest tu niezbędny ----
    public Library() {
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
