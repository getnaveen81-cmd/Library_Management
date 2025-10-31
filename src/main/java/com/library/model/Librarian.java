package com.library.model;

public class Librarian {
    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void greet() {
        System.out.println("Hello! I'm Librarian " + name + ". How can I assist you today?");
    }
}
