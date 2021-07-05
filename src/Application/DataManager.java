package Application;

import JavaRecipes.Ingredient;

import java.sql.ResultSet;

public class DataManager {

    private SqliteSupport dbSqlite;

    public DataManager(){

        dbSqlite = new SqliteSupport();
        dbSqlite.tablesCreate();
    }
    public boolean insertIngredient(String name, String description, float portion,
                                    String portion_label, String store_name, String category, float min_stock){
        Ingredient ingredient = new Ingredient(name, description, portion, portion_label, store_name, category, min_stock);
        return dbSqlite.InsertIngredient(ingredient);
    }
    public boolean updateIngredient(int id, String name, String description, float portion,
                                    String portion_label, String store_name, String category, float min_stock){
        Ingredient ingredient = new Ingredient(name, description, portion, portion_label, store_name, category, min_stock);
        return dbSqlite.UpdateIngredient(id,ingredient);
    }
    public boolean deleteIngredient(int id){
        return dbSqlite.DeleteIngredient(id);
    }
    public Ingredient selectIngredient(int id){
        return dbSqlite.SelectIngredientByID(id);
    }
    public ResultSet selectAllIngredients(){
        return dbSqlite.SelectAllIngredients();
    }
    public void disconnectDB(){
        dbSqlite.disconnect();
        dbSqlite.setDbConnected(false);
    }
}
