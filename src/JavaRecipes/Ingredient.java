package JavaRecipes;
public class Ingredient {
    private String name;
    private String description;
    private float portion;
    private String portion_label ;
    private String store_name;
    private String category;
    private float min_stock;

    public Ingredient(){
        name = "New Ingredient";
        description = "this is the description";
        portion = 100.00f;
        portion_label = "gramos";
        store_name = "store";
        category = "ingredients";
        min_stock = 10;
    }
    public Ingredient(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Ingredient(String name, String description, float portion, String portionLabel) {
    	this.name = name;
    	this.description = description;
    	this.portion = portion;
    	this.portion_label = portionLabel;
    }

    public String getPortion_label() {
        return portion_label;
    }

    public void setPortion_label(String portion_label) {
        this.portion_label = portion_label;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPortion(float portion){
        this.portion = portion;
    }
    public void setMin_stock(float min_stock) {
        this.min_stock = min_stock;
    }
    public float getMin_stock() {
        return min_stock;
    }

    public float getPortion(){
        return portion;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getFullDescription(){
        return name + "\n" + description;
    }
    public String getRecipeDescription(){
        return name + " - " + portion + " " + portion_label;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
