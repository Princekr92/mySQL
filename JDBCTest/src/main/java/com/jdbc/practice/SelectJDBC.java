/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

/**
 *
 * @author Prince
 */
public class SelectJDBC {
    
    public static void main(String [] args){
		try{

			Class.forName("com.mysql.jdbc.Driver");

			// creating a connection

			String url="jdbc:mysql://localhost:3306/youtube?useSSL=false";
			String username="root";
			String password="";

			Connection con=DriverManager.getConnection(url,username,password);

			// create a query
			String q="select * from table1";

			Statement stmt=con.createStatement();
			ResultSet set=stmt.executeQuery(q);

			while(set.next()){
				int id=set.getInt(1);
				String name=set.getString(2);
				String city=set.getString(3);
			}
			con.close();

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
    

