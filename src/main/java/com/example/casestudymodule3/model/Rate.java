package com.example.casestudymodule3.model;

public class Rate {
    private int id;
    private int bookId;
    private int rate;

    public Rate() {
    }

    public Rate(int id, int bookId, int rate) {
        this.id = id;
        this.bookId = bookId;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
