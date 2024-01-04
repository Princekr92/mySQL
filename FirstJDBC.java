import java.sql.*;

class FirstJDBC {
    public static void main(String[] args) {
        String JdbcURL = "jdbc:mysql://localhost:3306/youtube?useSSL=false";
        String Username = "root";
        String password = "";
        Connection con = null;

        try {
            con = DriverManager.getConnection(JdbcURL, Username, password);
            System.out.println("Connected to MySQL database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
