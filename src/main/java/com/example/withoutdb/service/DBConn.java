package com.example.withoutdb.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
@Service
public class DBConn {
    public static Connection getMyConnection() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //conn = DriverManager.getConnection("jdbc:mysql://nxt-database.cp8kqw48c26v.us-east-1.rds.amazonaws.com:3306/nxtdb?useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=1500", "root", "root");
            conn = DriverManager.getConnection("jdbc:mysql://nxt-database.cp8kqw48c26v.us-east-1.rds.amazonaws.com:3306/nxtdb", "admin", "password123");

        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return conn;
    }
}
