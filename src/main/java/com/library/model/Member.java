package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void printBorrowedBooks() {
        System.out.println("Borrowed books by " + name + ": " + borrowedBooks);
    }


    @Override
    public String toString() {
        return "Member{" + "id='" + memberId + '\'' + ", name='" + name + '\'' + ", borrowedBooks=" + borrowedBooks.size() + '}';
    }
}
