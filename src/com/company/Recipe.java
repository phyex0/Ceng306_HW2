package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recipe {


    private List<Ingredient> ingredients;
    private final static String ingredientPath = "src/com/ingredient.txt";

    public Recipe() throws IOException {
        this.ingredients = new ArrayList<>();
        loadMaterials(ingredientPath,ingredients);

    }

    public int search(String name,List<Ingredient> list ) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equalsIgnoreCase(name))
                return i;

        }
        return -1;
    }

    public void loadMaterials(String path, List<Ingredient> list) throws IOException {
        List<String> input = FileIO.readFile(path);
        for(String parameters :input){
            String param[] = parameters.split(",");
            if(param.length == 4)
                list.add(new Ingredient(param[0],Double.parseDouble(param[1]),Double.parseDouble(param[2]),Boolean.parseBoolean(param[3])));
        }


    }

    public void isEnough(List<Ingredient> list){
        System.out.println("Checking for materials...");
        int index;
        for(int i=0;i<list.size();i++){
            if((index = search(list.get(i).getName(),ingredients))!=-1){
                if(list.get(i).getWeight()>ingredients.get(index).getWeight()){
                    addExtraMaterials(list.get(i).getName());
                    isEnough(list);
                }
            }
            else {
                addExtraMaterials(list.get(i).getName());
                isEnough(list);
            }
        }

    }

    public boolean isEnough(Ingredient ingredient){
        int index=search(ingredient.getName(),ingredients);

        if(index!=-1){
            if(ingredient.getWeight()>ingredients.get(index).getWeight())
                return false;
        }

        else if(index==-1)
           return false;

        return true;


    }


    public void addExtraMaterials(String ingredientName){
        Scanner scanner = new Scanner(System.in);
        int index = search(ingredientName,ingredients);
        if(index >= 0){
            System.out.println("Add more "+ingredients.get(index).getName());
            System.out.println("Enter added weight for "+ingredientName);
            double newWeight= scanner.nextDouble();
            ingredients.get(index).setWeight(ingredients.get(index).getWeight()+newWeight);
        }

        else{
            Ingredient newIngredient = new Ingredient();
            System.out.println("Enter required infos for "+ingredientName);
            newIngredient.setName(ingredientName);
            System.out.println("Enter calorie of food");
            newIngredient.setCalorie(scanner.nextDouble());
            System.out.println("Enter weight");
            newIngredient.setWeight(scanner.nextDouble());
            System.out.println("This is a plant? Or sub material (Yes/No)");
            String result= scanner.nextLine();

            if (result.equalsIgnoreCase("Yes"))
                newIngredient.setPlant(true);
            else
                newIngredient.setPlant(false);

            ingredients.add(newIngredient);

        }



    }
    public void useIngredients(List<Ingredient> list){
        int index;
        for(int i=0;i<list.size();i++){
            index = search(list.get(i).getName(),ingredients);
            System.out.println(list.get(i).getName()+" used "+list.get(i).getWeight()+" unit");
            ingredients.get(index).setWeight(ingredients.get(index).getWeight()-list.get(i).getWeight());

        }

    }

    public void makePie() throws IOException {
        final String path = "src/com/pie.txt";
        List<Ingredient> pieList = new ArrayList<>();
        loadMaterials(path,pieList);
        isEnough(pieList);

        int index = search("apple",pieList);
        pieList.get(index).wash();
        pieList.get(index).hull();
        useIngredients(pieList);
        calculateCalorie(pieList);



    }

    public void calculateCalorie(List<Ingredient> list){
        double total=0;
        for(int i=0;i<list.size();i++)
            total+= list.get(i).getCalorie()*list.get(i).getWeight();
        System.out.println("Total Calorie :"+total);
    }





    public void printInventory(){
        String all="Ingredients :\n-------------\n";
        for(Ingredient i:ingredients)
            all+= i.toString();
        System.out.println(all);;
    }

    public void menu() throws IOException {
        Scanner input = new Scanner(System.in);
        int selection;
        while(true) {
            System.out.println("1. Print Inventory\n2. Make apple pie\n3.Exit");
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    printInventory();
                    break;
                case 2:
                    makePie();
                    break;
                case 3:
                    System.out.println("Good bye!");
                    return;
                default:
                    System.out.println("Wrong Input, enter again!!");
                    break;

            }
        }
    }
}
