package com.example.casestudymodule3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String url= "jdbc:mysql://localhost:3306/case3";
    private  static final String user ="root";
    private static final String pass ="dung25081995";

    public static Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(url,user,pass);
            System.out.println("Connect Successfully");
        } catch (SQLException e) {
            System.out.println("Connect Failure!");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }

//    public static void main(String[] args) {
//        ConnectionCSM connectionCSM = new ConnectionCSM();
//        connectionCSM.getConnection();
//    }








}
