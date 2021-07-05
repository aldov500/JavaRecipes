package Application;

import JavaRecipes.Ingredient;

import java.sql.*;

public class SqliteSupport{
    //private String dbUrl = "jdbc:sqlite:C:/Users/101324781/Documents/development_test/java/JavaRecipes/db/data.db";
    private String dbName;
    private String dbUrl;
    private Connection conn;
    private boolean dbConnected;
    private String sqlCreateIngredients = "CREATE TABLE IF NOT EXISTS ingredients (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	name text NOT NULL,\n"
            + "	description text NOT NULL,\n"
            + "	portion real NOT NULL,\n"
            + "	portion_label text NOT NULL,\n"
            + "	store_name text NOT NULL,\n"
            + "	category text NOT NULL,\n"
            + "	min_stock real\n"
            + ");";
    private String sqlSelectIngredientById = "SELECT * \n"
            + "FROM ingredients \n"
            + "WHERE id = ?";
    private String sqlSelectAllIngredients = "SELECT * \n"
            + "FROM ingredients";
    private String sqlInsertIngredient="INSERT INTO ingredients\n"
            + "(name,description,portion, portion_label, store_name, category, min_stock)\n"
            + "VALUES(?,?,?,?,?,?,?)";
    private String sqlUpdateIngrendient = "UPDATE ingredients \n"
            + "SET \n"
            + "name = ?,\n"
            + "description = ?,\n"
            + "portion = ?,\n"
            + "portion_label = ?,\n"
            + "store_name = ?,\n"
            + "category = ?,\n"
            + "min_stock = ?\n"
            + "WHERE\n"
            + "id = ?";
    private String sqlDeleteIngredientById = "DELETE FROM ingredients\n"
            + "WHERE id = ?";

    SqliteSupport(){
        dbName = "db.db";
        dbUrl = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\db\\" + dbName;
        dbConnected = false;
        try {
            conn = DriverManager.getConnection(dbUrl);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    // Open connection to database
    public boolean connect(){
        if(dbConnected){
            return true;
        }else{
            try {
                conn = DriverManager.getConnection(dbUrl);
                System.out.println("Connection to SQLite has been established.");
                dbConnected = true;
                return true;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
        }
    }
    // Close connection to database
    public boolean disconnect(){
        try {
            if (conn != null) {
                conn.close();
                dbConnected = false;
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

                // SQL statement for creating new tables
                Statement stmt = conn.createStatement();
                stmt.execute(sqlCreateIngredients);

            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("The database was not able to connect");
        }
    }
    // Ingredients
    public boolean InsertIngredient(Ingredient newIngredient){
        if(connect()){
            try{
                PreparedStatement sqlInsert = conn.prepareStatement(sqlInsertIngredient);
                sqlInsert.setString(1,newIngredient.getName());
                sqlInsert.setString(2,newIngredient.getDescription());
                sqlInsert.setFloat(3,newIngredient.getPortion());
                sqlInsert.setString(4,newIngredient.getPortion_label());
                sqlInsert.setString(5,newIngredient.getStore_name());
                sqlInsert.setString(6,newIngredient.getCategory());
                sqlInsert.setFloat(7,newIngredient.getMin_stock());
                sqlInsert.executeUpdate();
                //disconnect();
                return true;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Error at connection");

        }
        return false;
    }
    public boolean UpdateIngredient(int ingredientID,Ingredient updatedIngredient){
        if(connect()){
            try{
                PreparedStatement queryUpdate = conn.prepareStatement(sqlUpdateIngrendient);
                queryUpdate.setString(1,updatedIngredient.getName());
                queryUpdate.setString(2,updatedIngredient.getDescription());
                queryUpdate.setFloat(3,updatedIngredient.getPortion());
                queryUpdate.setString(4, updatedIngredient.getPortion_label());
                queryUpdate.setString(5,updatedIngredient.getStore_name());
                queryUpdate.setString(6,updatedIngredient.getCategory());
                queryUpdate.setFloat(7, updatedIngredient.getMin_stock());
                queryUpdate.setInt(8,ingredientID);
                queryUpdate.executeUpdate();
                //disconnect();
                return true;
            }catch(SQLException e){
                System.out.println(e.getMessage());
                return false;
            }

        }else{
            return false;
        }

    }
    public boolean DeleteIngredient(int ingredientID){
        if(connect()){
            try{
                PreparedStatement queryDelete = conn.prepareStatement(sqlDeleteIngredientById);
                queryDelete.setInt(1,ingredientID);
                queryDelete.executeUpdate();
                //disconnect();
                return true;
            }catch(SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }else{
            System.out.println("Error connecting");
        }
        return false;
    }
    public Ingredient SelectIngredientByID(int ingredientId){
        // Seek in database
        Ingredient ingredient = new Ingredient();
        if(connect()){
            try {
                PreparedStatement sqlQuery = conn.prepareStatement(sqlSelectIngredientById);
                sqlQuery.setDouble(1,(double)ingredientId);
                ResultSet result = sqlQuery.executeQuery();
                while(result.next()){
                    ingredient.setName(result.getString("Name"));
                }

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Error connecting");
        }
        return ingredient;
    }
    public ResultSet SelectAllIngredients(){
        Ingredient[] result = new Ingredient[1000];
        ResultSet resultSet;// = new ResultSet("");

        if(connect()){
            try {
                PreparedStatement sqlQuery = conn.prepareStatement(sqlSelectAllIngredients);
                resultSet = sqlQuery.executeQuery();
                Ingredient newRecord = new Ingredient();
                int index = 0;
                while(resultSet.next()){
                    newRecord.setName(resultSet.getString("Name"));
                    result[index++] = newRecord;
                }
                return resultSet;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Error connecting");
        }
        return null;
    }
    public boolean isDbConnected() {
        return dbConnected;
    }
    public void setDbConnected(boolean dbConnected) {
        this.dbConnected = dbConnected;
    }
}
