package com.example.casestudymodule3.model;

public class Book {
    private int id;
    private String name;
    private String describe;
    private String author;
    private String category;
    private String publishers;
    private String status;
    private String img;

    public Book() {
    }

    public Book(int id, String name, String describe, String author, String category, String publishers, String status, String img) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.author = author;
        this.category = category;
        this.publishers = publishers;
        this.status = status;
        this.img = img;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
