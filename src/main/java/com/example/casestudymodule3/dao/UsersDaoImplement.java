package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.connection.ConnectionDB;
import com.example.casestudymodule3.model.Role;
import com.example.casestudymodule3.model.Users;
import com.sun.org.apache.xerces.internal.util.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersDaoImplement implements IUsersDAO {
    private final Connection connection= ConnectionDB.getConnection();
    private static final String QUERY_ALL_USERS = "SELECT * FROM USERS";
    private static final String QUERY_INSERT_ACCOUNT_BY_ADMIN= "INSERT INTO USERS" +
            "(ACCOUNT,PASSWORD,FIRSTNAME,LASTNAME,ADDRESS,PHONE,EMAIL,ROLE) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String QUERY_DEL_USERS_BY_ADMIN = "DELETE FROM USERS WHERE ID = ?";
    private static final String QUERY_UPDATE_BY_USER = "UPDATE USERS SET PASSWORD = ?,FIRSTNAME = ?,LASTNAME = ?,ADDRESS = ?,PHONE = ?,EMAIL= ?,BIRTHDAY =? " +
            "WHERE ACCOUNT = ?";
    private static final String QUERY_UPDATE_BY_ADMIN = "UPDATE USERS SET STATUS = ? WHERE ID = ?";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM USERS WHERE ID = ?";
    private static final String QUERY_FIND_PASS_BY_ACCOUNT = "SELECT PASSWORD FROM USERS WHERE ACCOUNT = ? AND EMAIL = ?";
    private static final String QUERY_FIND_BY_USER = "SELECT ID FROM USERS WHERE ACCOUNT = ? AND PASSWORD = ?";

    public List<Users> getAll() {
        List<Users>users=new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_USERS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String address = rs.getString(6);
                String phone = rs.getString(7);
                String email = rs.getString(8);
                Role role = Role.valueOf(rs.getString(9);
                Status status = Status.valueOf(rs.getString(10));
                users.add(new Users(id, account, password, firstname, lastname, address, phone, email, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
public String findPassByAccount



}
