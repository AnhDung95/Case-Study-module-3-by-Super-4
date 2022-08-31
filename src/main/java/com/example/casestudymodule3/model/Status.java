package com.example.casestudymodule3.model;

public enum Status {
    NEW(1),
    OLD(0);
    private final int status;
    Status(int status) {
        this.status = status;
    }
    public int getStatus(){
        return status;
    }
}
