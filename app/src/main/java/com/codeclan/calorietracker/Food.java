package com.codeclan.calorietracker;

/**
 * Created by miguelmorenobaladron on 3/27/18.
 */

public class Food {
    private String name;
    private Double proteins;
    private Double carbs;
    private Double fats;
    private int id;
    //private String date;

    public Food(String name, Double proteins, Double carbs, Double fats) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
    }

    public Food(int id, String name, Double proteins, Double carbs, Double fats) {
        this.name = name;
        this.id = id;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
    }

    public int getId() { return this.id; }

    public String getName(){
        return this.name;
    }

    public Double getProteins(){
        return this.proteins;
    }

    public Double getCarbs(){
        return this.carbs;
    }

    public Double getFats(){
        return this.fats;
    }

}
