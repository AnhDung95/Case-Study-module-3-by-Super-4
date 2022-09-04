package com.example.casestudymodule3.model;

public class Users {
    private int id;
    private String account;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private Role role;

    public Users(int id, String account, String password, String firstName, String lastName, String address, String phone, String email, Role role) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public Users(String account, String password, String firstName, String lastName, String address, String phone, String email, Role role) {
        this.account = account;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public Users(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Users(int id, String account, String password, String firstName, String lastName, String address, String phone, String email) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
