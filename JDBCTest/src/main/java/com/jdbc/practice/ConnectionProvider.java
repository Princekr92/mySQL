/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;
import java.sql.Connection;

import java.sql.*;

/**
 *
 * @author Prince
 */
public class ConnectionProvider {
    private static Connection con;
    
    public static Connection getConnection() {
    try {
        if (con == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/youtube";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return con;
}

}
