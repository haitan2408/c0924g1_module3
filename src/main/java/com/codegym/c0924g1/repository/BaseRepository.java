package com.codegym.c0924g1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/demo_c0724m1?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "28101998";
    private static Connection connection =null;
    private BaseRepository() {

    }
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
