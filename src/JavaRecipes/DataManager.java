package JavaRecipes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {
    private String databaseName = "db.db";

    public DataManager(){
        sqliteSupport dbSupport = new sqliteSupport();
        dbSupport.tablesCreate();

    }
    // xml support
    private class xmlSupport{

    }
    // sqlite support
    private class sqliteSupport{
        //private String dbUrl = "jdbc:sqlite:C:/Users/101324781/Documents/development_test/java/JavaRecipes/db/data.db";
        private String dbUrl;
        private Connection conn;

        sqliteSupport(){
            conn = null;
            dbUrl = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\db\\" + databaseName;
        }
        // Open connection to database
        public boolean connect(){
            try {
                conn = DriverManager.getConnection(dbUrl);
                System.out.println("Connection to SQLite has been established.");
                return true;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
        }
        // Close connection to database
        public boolean disconnect(){
            try {
                if (conn != null) {
                    conn.close();
                    return true;
                }
                return false;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        // Function that creates the tables
        public void tablesCreate(){
            if(connect()){
                try {
                    // SQL statement for creating a new table
                    Statement stmt = conn.createStatement();
                    String sql_create = "CREATE TABLE IF NOT EXISTS ingredients (\n"
                            + "	id integer PRIMARY KEY,\n"
                            + "	name text NOT NULL,\n"
                            + "	description text NOT NULL,\n"
                            + "	portion real\n"
                            + "	portion_label text NOT NULL,\n"
                            + "	store_name text NOT NULL,\n"
                            + "	category text NOT NULL,\n"
                            + "	min_stock real\n"
                            + ");";

                    stmt.execute(sql_create);
                } catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }else{

            }
        }
    }
}
