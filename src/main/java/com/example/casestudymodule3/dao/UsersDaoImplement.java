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
                Role role = Role.valueOf(rs.getString(9));
                Status status = Status.valueOf(rs.getString(10));
                users.add(new Users(id, account, password, firstname, lastname, address, phone, email, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean add(Users users) {
        boolean rowAdded = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_ACCOUNT_BY_ADMIN);
            statement.setString(1, users.getAccount());
            statement.setString(2, users.getPassword());
            statement.setString(3, users.getFirstName());
            statement.setString(4, users.getLastName());
            statement.setString(5, users.getAddress());
            statement.setString(6, users.getPhone());
            statement.setString(7, users.getEmail());
            statement.setString(8, String.valueOf(users.getRole()));
            rowAdded = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAdded;
    }

    public boolean update(int id, Users users) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_BY_ADMIN);
            statement.setInt(1,id);
            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    public boolean delete(int id) {
        boolean rowDel = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DEL_USERS_BY_ADMIN);
            statement.setInt(1,id);
            rowDel = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDel;
    }

    public Users findById(int id) {
        Users user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String account = rs.getString(2);
                String password = rs.getString(3);
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String address = rs.getString(6);
                String phone = rs.getString(7);
                String email = rs.getString(8);
                Role role = Role.valueOf(rs.getString(9));
                user = new Users(id,account,password,firstname,lastname,address,phone,email,role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user ;
    }
    public String findPassByAccount(String account, String email) {
        String pass = "";
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_PASS_BY_ACCOUNT);
            statement.setString(1,account);
            statement.setString(2,email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String password = rs.getString(1);
                pass = password;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pass;
    }
    public boolean updateByUser(String account,Users users) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_BY_USER);
            statement.setString(1, users.getPassword());
            statement.setString(2,users.getFirstName());
            statement.setString(3,users.getLastName());
            statement.setString(4,users.getAddress());
            statement.setString(5,users.getPhone());
            statement.setString(6,users.getEmail());
            statement.setString(7,account);
            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public int findByUser(Users users) {
        int id = -1;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_BY_USER);
            statement.setString(1, users.getAccount());
            statement.setString(2, users.getPassword());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }



}
