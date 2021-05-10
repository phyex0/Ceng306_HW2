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
        this.isJuicy = false;
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

    public boolean isJuicy() {
        return isJuicy;
    }

    public void setJuicy(boolean juicy) {
        isJuicy = juicy;
    }

    public boolean isPlant() {
        return isPlant;
    }

    public void setPlant(boolean plant) {
        isPlant = plant;
    }

    public void wash(){
        if(isPlant){
            if(isJuicy)
                System.out.println(getName()+" Juice cannot wash");
            else
                isWashed=true;
        }

        else
            System.out.println("Given ingredient is not plant");

    }
    public void hull(){
        if(isPlant){
            if(isJuicy)
                System.out.println(getName()+" Juice cannot hull");
            else
                isHulled=true;
        }

        else
            System.out.println("Given ingredient is not plant");
    }

    public void makeJuicy(){
        if(isPlant){
            if(isJuicy)
                System.out.println(getName()+" is a juicy already");
            else
                isJuicy=true;
        }

        else
            System.out.println("Given ingredient is not plant");

    }


    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", calorie=" + calorie +
                ", weight=" + weight +
                ", isPlant=" + isPlant +
                ", isWashed=" + isWashed +
                ", isHulled=" + isHulled +
                ", isJuicy=" + isJuicy +
                '}';
    }
}
