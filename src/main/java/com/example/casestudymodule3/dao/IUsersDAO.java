package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.model.Users;

import java.sql.SQLException;

public interface IUsersDAO {
    String findPassByAccount(String account, String email);
    boolean updateByUser(String account,Users users);
    int findByUser(Users users);

}
