
import JavaRecipes.Recipe;
import JavaRecipes.Ingredient;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Recipe caldoDePollo = new Recipe("Caldo de Pollo");
	
		caldoDePollo.addIngredient(new Ingredient(1.0f, "Pieza completa", "Pollo"));
		caldoDePollo.addIngredient(new Ingredient(8.0f, "Tazas", "Agua"));
		caldoDePollo.addIngredient(new Ingredient("Sal","Pollo entero crudo", 2, "cucharaditas"));
		caldoDePollo.addIngredient(new Ingredient("Cebolla blanca","Pollo entero crudo", 1.5f, "mediana"));
		caldoDePollo.addIngredient(new Ingredient("Dientes de Ajo","Pollo entero crudo", 4, "pelados"));
		caldoDePollo.addIngredient(new Ingredient("Ramas de Apio","Pollo entero crudo", 2, "en trozos"));
		caldoDePollo.addIngredient(new Ingredient("Perejil","Pollo entero crudo", 3, "ramas"));
		caldoDePollo.addIngredient(new Ingredient("Zanahoria","Pollo entero crudo", 3, "cortadas"));
		caldoDePollo.addIngredient(new Ingredient("Cilantro","Pollo entero crudo", 2, "ramas"));
		
		caldoDePollo.setInstructions("Echa el pollo, el agua y la sal en una olla grande, y empieza a cocinar a temperatura media alta hasta que suelte el hervor. Una vez que suelte el hervor se formará espuma en la superficie; procede a removerla y desecharla.\r\n"
				+ "Después de quitar la espuma, agrega la cebolla, el ajo y el apio, y cubre la olla parcialmente. Baja la temperatura y cocina lentamente por aprox. 30 minutos sin dejarlo que hierva.\r\n"
				+ "Agrega las zanahorias y el cilantro. En este momento verifica si el pollo ya está cocido y tierno. Si ya está cocido, retíralo y pónlo en un recipiente aparte.\r\n"
				+ "Sigue cocinando el caldo por 10 minutos más hasta que las zanahorias estén completamente cocidas.\r\n"
				+ "Cuando las piezas del pollo no estén tan calientes, deshébralas o pártelas en pedazos pequeños. Cuando las zanahorias ya estén cocidas, pártelas en cubos y sepáralas.");
		
		System.out.println(caldoDePollo.getFullDescription());
	}

}
