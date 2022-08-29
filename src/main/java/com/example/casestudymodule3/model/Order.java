package com.example.casestudymodule3.model;

import java.time.LocalDate;

public class Order {
    private int id;
    private int idUser;
    private LocalDate create;
    private LocalDate duration;
    private String status;
    private String address;
    private String phone;

    public Order(int id, int idUser, LocalDate create, LocalDate duration, String status, String address, String phone) {
        this.id = id;
        this.idUser = idUser;
        this.create = create;
        this.duration = duration;
        this.status = status;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public LocalDate getCreate() {
        return create;
    }

    public void setCreate(LocalDate create) {
        this.create = create;
    }

    public LocalDate getDuration() {
        return duration;
    }

    public void setDuration(LocalDate duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
