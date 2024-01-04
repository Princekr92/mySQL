import java.sql.*;
import java.io.*;

class LargeImage
{

	public static void main(String [] args){
		try{
			Class.forName("com.mysql.jdbc.Driver");

			// creating a connection

			String url="jdbc:mysql://localhost:3306/youtube?useSSL=false";
			String username="root";
			String password="";

			Connection con=DriverManager.getConnection(url,username,password);

			// create a query
			 try (PreparedStatement pstmt = c.prepareStatement(q)) {
                JFileChooser jfc = new JFileChooser();

                int result = jfc.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = jfc.getSelectedFile();

                    try (FileInputStream fis = new FileInputStream(file)) {
                        pstmt.setBinaryStream(1, fis, fis.available());
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Success");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "File selection canceled");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }

}
}