package com.library;

import com.library.model.*;
import com.library.service.*;

public class Main {
    public static void main(String[] args) {
        Librarian librarian = new Librarian("Ravi");
        librarian.greet();

        LibraryService library = new LibraryService();
        FineService fineService = new FineService();

        Book book1 = new Book("B101", "The Alchemist", "Paulo Coelho");
        Book book2 = new Book("B102", "Clean Code", "Robert C. Martin");
        Book book3 = new Book("B103", "Java Concurrency in Practice", "Brian Goetz");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Member member1 = new Member("M001", "Naveen");
        Member member2 = new Member("M002", "Anita");

        library.registerMember(member1);
        library.registerMember(member2);

        library.borrowBook("B101", "M001");
        library.borrowBook("B102", "M002");

        library.showAllBooks();
        library.showMembers();

        fineService.addFine(member1, 50);
        fineService.showAllFines();

        fineService.payFine(member1, 20);
        fineService.showAllFines();

        library.returnBook("B101", "M001");
        library.showAllBooks();
    }
}
