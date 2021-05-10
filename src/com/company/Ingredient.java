package com.company;

public class Ingredient {
    private String name;
    private double calorie;
    private double weight;

    private boolean isPlant;
    private boolean isWashed;
    private boolean isHulled;
    private boolean isJuicy;
    public Ingredient() {
    }

    public Ingredient(String name, double calorie, double weight,boolean isPlant) {
        this.name = name;
        this.calorie = calorie;
        this.weight = weight;
        this.isPlant = isPlant;
        this.isWashed = false;
        this.isHulled = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isWashed() {
        return isWashed;
    }

    public void setWashed(boolean washed) {
        isWashed = washed;
    }

    public boolean isHulled() {
        return isHulled;
    }

    public void setHulled(boolean hulled) {
        isHulled = hulled;
    }


    public boolean isPlant() {
        return isPlant;
    }

    public void setPlant(boolean plant) {
        isPlant = plant;
    }

    public void wash(){
        if(isPlant){
            System.out.println(name+ " is washed");
            isWashed=true;
        }

        else
            System.out.println("Given ingredient is not plant");

    }
    public void hull(){
        if(isPlant){
            System.out.println(name+" is Hulled");
            isHulled=true;
        }

        else
            System.out.println("Given ingredient is not plant");
    }




    @Override
    public String toString() {
        return  "name=" + name +
                "\ncalorie=" + calorie +
                "\nweight=" + weight +
                "\nisPlant=" + isPlant +
                "\nisWashed=" + isWashed +
                "\nisHulled=" + isHulled +
                "\n-------------------------------------------\n";
    }
}
