package com.ra.model.entity;

public class Book {
    private int id;
    private String bookName;
    private double price;
    private String author;

    public Book() {
    }

    public Book(int id, String bookName, double price, String author) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
