package com.library.model;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void printAllBooks() {
        books.values().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Library with " + books.size() + " books.";
    }
}
