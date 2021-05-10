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

    }

    public int search(String name ) {
        for(int i=0;i<ingredients.size();i++){
            if(ingredients.get(i).getName().equalsIgnoreCase(name))
                return i;

        }
        return -1;
    }

    public void loadMaterials(String path, List<Ingredient> list) throws IOException {
        List<String> input = FileIO.readFile(path);
        for(String parameters :input){
            String param[] = parameters.split(",");
                list.add(new Ingredient(param[0],Double.parseDouble(param[1]),Double.parseDouble(param[2]),Boolean.parseBoolean(param[3])));
        }


    }

    public void isEnough(List<Ingredient> list){
        int index;
        for(int i=0;i<list.size();i++){
            if((index = search(list.get(i).getName()))!=-1){
                if(list.get(i).getWeight()>ingredients.get(index).getWeight())
                    addExtraMaterials(list.get(i).getName());
            }
            else
                addExtraMaterials(list.get(i).getName());

        }
    }



    public void addExtraMaterials(String ingredientName){
        Scanner scanner = new Scanner(System.in);
        int index = search(ingredientName);
        if(index >= 0){
            System.out.println("Add more "+ingredients.get(index).getName());
            double newWeight= scanner.nextDouble();
            ingredients.get(index).setWeight(ingredients.get(index).getWeight()+newWeight);
        }

        else{
            Ingredient newIngredient = new Ingredient();
            System.out.println("Enter the material name");
            newIngredient.setName(scanner.nextLine());
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

    public void makePie(String plantName) throws IOException {
        final String path = "src/com/pie.txt";
        List<Ingredient> pieList = new ArrayList<>();
        loadMaterials(path,pieList);
        isEnough(pieList);




    }


    public void makeMenemen(){}

    public void menu(){}

}
