package com.library.model;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available = true;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isByAuthor(String authorName) {
        return author.toLowerCase().startsWith(authorName.toLowerCase());
    }

    public void myBook(){
        System.out.println("Mindset");
    }


    @Override
    public String toString() {
        return "[" + title + "] - Author: " + author;
    }

    public String shortInfo() {
        return title + " by " + author;
    }

    public void dummy(){
        System.out.println("dummy1");
    }

}
