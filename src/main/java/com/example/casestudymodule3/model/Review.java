package com.example.casestudymodule3.model;

public class Review {
    private int id;
    private int bookId;
    private String accountUser;
    private String comment;

    public Review() {
    }

    public Review(int id, int bookId, String accountUser, String comment) {
        this.id = id;
        this.bookId = bookId;
        this.accountUser = accountUser;
        this.comment = comment;
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

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
