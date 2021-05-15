package JavaRecipes;
import java.util.LinkedList;

public class Recipe {

    private LinkedList<Ingredient> ingredients;
    private String instructions;
    private String name;

    public Recipe(){
        ingredients = new LinkedList<Ingredient>();
        instructions = "Description of the process of preparation";
    }
    public Recipe(String name){
    	ingredients = new LinkedList<Ingredient>();
    	this.name = name;
    }
    
    public Recipe(LinkedList<Ingredient> ingredients) {
    	this.ingredients = ingredients;
    	this.name = "Receta nueva";
    }
    
    public Recipe(String name, String instructions, LinkedList<Ingredient> ingredients) {
    	this.ingredients = ingredients;
    	this.instructions = instructions;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setIngredients(LinkedList<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions){
        this.instructions = instructions;
    }
    
    public String getName() {
    	return name;
    }
    public LinkedList<Ingredient> getIngredients(){
        return ingredients;
    }

    public String getInstructions(){
        return instructions;
    }
    
    public void addIngredient(Ingredient ingredient) {
    	ingredients.add(ingredient);
    }
    
    public String getFullDescription() {
    	String result;
    	
    	result = name + "\n";
    	
    	for(Ingredient ing : ingredients) {
    		result += ing.getPortion() +" " + ing.getPortionLabel() + " de " + ing.getName() + "\n";
    	}
    	
    	result += instructions + "\n";
    	
    	return result;
    }
}
