package com.library.service;

import com.library.model.Book;
import com.library.model.Member;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public void searchBook(String keyword) {
        books.values().stream()
                .filter(b -> b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .forEach(System.out::println);
    }


    public List<Book> sortBooksByTitle() {
        return books.values().stream() // <-- use values() to get a Collection<Book>
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    public List<String> filterBooksByAuthor(String author) {
        return books.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getAuthor() != null &&
                        entry.getValue().getAuthor().toLowerCase().contains(author.toLowerCase()))                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Book> sortBooksByAuthor() {
        return books.values().stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .collect(Collectors.toList());
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
