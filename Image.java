import java.sql.*;
import java.io.*;
class Image{
	public static void main(String []args){
		try{

			  //Class.forName("com.mysql.jdbc.Driver");
			  Class.forName("com.mysql.jdbc.Driver");

			// creating a connection

			String url="jdbc:mysql://localhost:3306/youtube?useSSL=false";
			String username="root";
			String password="";
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube?useSSL=false");

				// create query
			  String q="insert into images(pic) values(?)";

			  PreparedStatement pstmt=con.prepareStatement(q);

			  FileInputStream fis=new FileInputStream("prince.jpg");

			  pstmt.setBinaryStream(1,fis,fis.available());

			  pstmt.executeUpdate();

			  System.out.println("done....");
		}

		catch(Exception e){
			System.out.println("Error !!");
		}
	}
}