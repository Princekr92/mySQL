 
    // preparedStatement:insert

import java.sql.*;
import java.io.*;
class Dynamic
{
	public static void main(String [] args){
		try{
			Class.forName("com.mysql.jdbc.Driver");

			// creating a connection

			String url="jdbc:mysql://localhost:3306/youtube?useSSL=false";
			String username="root";
			String password="";

			Connection con=DriverManager.getConnection(url,username,password);

			// creat a query

			String q="insert into table1(tName,tCity) values (?,?)";

			// get the PreparedStatement object

			PreparedStatement pstmt=con.prepareStatement(q);

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name:");
			String name=br.readLine();

			System.out.println("Enter city:");
			String city=br.readLine();

			// set the values to query

			pstmt.setString(1,"name");
			pstmt.setString(2,"city");

			pstmt.executeUpdate();

			System.out.println("inserted...");

			con.close();
		}

		catch(Exception e){
			e.printStackTrace();
		}
	}
}

