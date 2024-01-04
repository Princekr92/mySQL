package com.jdbc.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Prince
 */
public class Main {
    public static void main(String[] args) {
        try {
            Connection c = ConnectionProvider.getConnection();

            String q = "insert into youtube(pic) values(?)";

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
