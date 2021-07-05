package Application;

import org.json.JSONArray;

import java.sql.SQLException;
import java.util.Scanner;

public class UI {
    private boolean running;
    private Scanner input;
    private ResultSetConverter resultSetConverter;

    public UI(){
        running = false;
        input = new Scanner(System.in);
    }

    public void init(){
        running = true;
        String inputLine;
        while(running){
            displayMenu();
            inputLine = input.nextLine();
            sop(inputLine,true);

            switch (Integer.parseInt(inputLine)){
                case 1:
                    displayAllIngredients();
                    break;
                case 2:
                    break;

                case 3:
                    break;

                case 4:

                    break;
                case 5:
                    running = false;
                    break;
            }
        }
    }

    private void displayMenu(){
        sop("Welcome to the recipes db",true);
        sop("Select one option:",true);
        sop("1. See all ingredients",true);
        sop("2. Create new ingredient",true);
        sop("3. Edit existing ingredient",true);
        sop("4. Search ingredient",true);
        sop("5. Exit",true);
    }

    private void displayAllIngredients(){
        sop("All Ingredients",true);
        DataManager dataManager = new DataManager();
        try {
            JSONArray jsonArray = resultSetConverter.convert(dataManager.selectAllIngredients());
            for(String value:resultSetConverter.toStringArray(jsonArray)){
                sop(value,true);
            }

        }catch(SQLException e){
            sop(e.getMessage(),true);
        }

    }

    private void sop(String message, boolean returnLine){
        if(returnLine){
            System.out.println(message);
        }else{
            System.out.print(message);
        }
    }
}
