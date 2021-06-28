package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseController {

    private String DatabaseController = "jdbc:sqlite:C:/Users/101324781/Documents/development_test/java/JavaRecipes/db/data.db";
    private Connection conn = null;

    // Open connection to database
    public void connect(){
        try {
            conn = DriverManager.getConnection(DatabaseController);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Close connection to database
    public void disconnect(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Create tables

    // Check if tables creatded
}
