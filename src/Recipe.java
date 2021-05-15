import java.util.LinkedList;

public class Recipe {

    private LinkedList<Ingredient> ingredients;
    private String instructions;

    public Recipe(){
        ingredients = new LinkedList<Ingredient>();
        instructions = "Description of the process of preparation";
    }

    public void setIngredients(LinkedList<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions){
        this.instructions = instructions;
    }

    public LinkedList<Ingredient> getIngredients(){
        return ingredients;
    }

    public String getInstructions(){
        return instructions;
    }
}
