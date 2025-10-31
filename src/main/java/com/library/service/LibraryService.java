package com.library.service;

import com.library.model.Book;
import com.library.model.Member;

import java.util.*;

public class LibraryService {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Added: " + book);
    }

    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println("New member registered: " + member.getName());
    }

    public void borrowBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            System.out.println("Invalid book or member ID.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed!");
            return;
        }

        book.setAvailable(false);
        member.borrowBook(book);
        System.out.println(member.getName() + " borrowed " + book.getTitle());
    }

    public void returnBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            System.out.println("Invalid book or member ID.");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("Book was not borrowed.");
            return;
        }

        book.setAvailable(true);
        member.returnBook(book);
        System.out.println(member.getName() + " returned " + book.getTitle());
    }

    public void showAllBooks() {
        System.out.println("\n📚 Available Books:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void showMembers() {
        System.out.println("\n👥 Registered Members:");
        for (Member m : members.values()) {
            System.out.println(m);
        }
    }
}
