package com.mbayefullstack.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{

    private static DatabaseConnection instance = new DatabaseConnection();    
    public static final String URL = "jdbc:mysql://localhost:3306/crud_websokect";
    public static final String USER = "root";
    public static final String PASSWORD = "A781000411a.";
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"; 
     
    //private constructor
    private DatabaseConnection() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database.");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to database", e);
        }
    }
     
    public static Connection getConnection() {
        return instance.createConnection();
    }
 
}
