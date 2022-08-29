package com.example.casestudymodule3.model;

public class RentalBill {
    private int orderId;
    private int bookId;
    private int quantity;
    private double total;

    public RentalBill() {
    }

    public RentalBill(int orderId, int bookId, int quantity, double total) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
