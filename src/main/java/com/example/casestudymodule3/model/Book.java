package com.example.casestudymodule3.model;

import java.sql.Timestamp;

public class Book {
    private int id;
    private String name;
    private String describe;
    private String author;
    private String category;
    private String publishers;
    private int quantity;
    private Timestamp createDay;
    private Status status;
    private String img;

    public Book(int id, String name, String describe, String author, String category, String publishers, String quantity) {
    }

    public Book(int id, String name, String describe, String author, String category, String publishers, int quantity, Timestamp createDay, Status status, String img) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.author = author;
        this.category = category;
        this.publishers = publishers;
        this.quantity = quantity;
        this.createDay = createDay;
        this.status = status;
        this.img = img;
    }

    public Book(String name, String describe, String author, int quantity, String img) {
        this.name = name;
        this.describe = describe;
        this.author = author;
        this.quantity = quantity;
        this.img = img;
    }

    public Book(int id, String name, String describe, String author, String category, String publishers, int quantity, String img) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.author = author;
        this.category = category;
        this.publishers = publishers;
        this.quantity = quantity;
        this.img = img;
    }

    public Book(String name, String describe, String author, String category, String publishers, int quantity, Timestamp createDay, Status status, String img) {
        this.name = name;
        this.describe = describe;
        this.author = author;
        this.category = category;
        this.publishers = publishers;
        this.quantity = quantity;
        this.createDay = createDay;
        this.status = status;
        this.img = img;
    }

    public Book(String name, String describe, String author, String category, String publishers, int quantity, String img) {
        this.name = name;
        this.describe = describe;
        this.author = author;
        this.category = category;
        this.publishers = publishers;
        this.quantity = quantity;
        this.img = img;
    }

    public Book(String name, String describe, int quantity, String img) {
        this.name = name;
        this.describe = describe;
        this.quantity = quantity;
        this.img = img;
    }
    public Book(String name, String describe,String author, int quantity, String img) {
        this.name = name;
        this.describe = describe;
        this.author=author;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Timestamp createDay) {
        this.createDay = createDay;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
