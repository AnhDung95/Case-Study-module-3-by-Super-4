package com.example.casestudymodule3.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    private static final String url ="jdbc:mysql://localhost:3306/bookcase";
    private static final String user ="root";
    private static final String password ="123456789";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("oke");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args) {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        connectionDatabase.getConnection();
    }
}
