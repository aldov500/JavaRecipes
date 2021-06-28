import Application.DatabaseController;

// Prototipo 01 
// Aplicacion que te otorga una lista de compras dependiendo de los platillos que elijas
// Prototipo 02
// Aplicacion que te otorga una lista de compras dependiendo de los platillos basado en tus productos actuales

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatabaseController base = new DatabaseController();
		base.connect();
		base.disconnect();
		return;

		/*
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

		caldoDePollo.setInstructions("Echa el pollo, el agua y la sal en una olla grande, y empieza a cocinar a temperatura media alta hasta que suelte el hervor. Una vez que suelte el hervor se formar� espuma en la superficie; procede a removerla y desecharla.\r\n"
				+ "Despu�s de quitar la espuma, agrega la cebolla, el ajo y el apio, y cubre la olla parcialmente. Baja la temperatura y cocina lentamente por aprox. 30 minutos sin dejarlo que hierva.\r\n"
				+ "Agrega las zanahorias y el cilantro. En este momento verifica si el pollo ya est� cocido y tierno. Si ya est� cocido, ret�ralo y p�nlo en un recipiente aparte.\r\n"
				+ "Sigue cocinando el caldo por 10 minutos m�s hasta que las zanahorias est�n completamente cocidas.\r\n"
				+ "Cuando las piezas del pollo no est�n tan calientes, desh�bralas o p�rtelas en pedazos peque�os. Cuando las zanahorias ya est�n cocidas, p�rtelas en cubos y sep�ralas.");

		System.out.println(caldoDePollo.getFullDescription());
		* */
	}

}
