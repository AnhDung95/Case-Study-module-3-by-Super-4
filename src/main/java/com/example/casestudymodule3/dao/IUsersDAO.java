package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.model.Users;

import java.sql.SQLException;

public interface IUserDAO {
    public void insertUsers(Users users) throws SQLException;


}
