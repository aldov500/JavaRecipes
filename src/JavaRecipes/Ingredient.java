package JavaRecipes;
public class Ingredient {
    private String name;
    private String description;
    private float portion;
    private String portionLabel ;

    public Ingredient(){
        name = "New Ingredient";
        description = "this is the description";
        portion = 100.00f;
        portionLabel = "gramos";
    }
    public Ingredient(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Ingredient(String name, String description, float portion, String portionLabel) {
    	this.name = name;
    	this.description = description;
    	this.portion = portion;
    	this.portionLabel = portionLabel;
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
    public void setPortionLabel(String portionLabel){
        this.portionLabel = portionLabel;
    }
    public String getPortionLabel(){
        return portionLabel;
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
        return name + " - " + portion + " " + portionLabel;
    }
}
