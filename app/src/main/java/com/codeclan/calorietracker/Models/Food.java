package com.codeclan.calorietracker.Models;

import java.io.Serializable;

/**
 * Created by miguelmorenobaladron on 3/27/18.
 */

public class Food implements Serializable{
    private String name;
    private Double proteins;
    private Double carbs;
    private Double fats;
    private Integer calories;
    private int id;
    //private String date;

    public Food(String name, Double proteins, Double carbs, Double fats) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.calories = createCalories();
    }



    public Food(int id, String name, Double proteins, Double carbs, Double fats) {
        this.name = name;
        this.id = id;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.calories = createCalories();
    }

    public Integer createCalories() {
        Double caloriesDouble = this.proteins * 4 + this.carbs * 4 + this.fats * 9;
        Math.round(caloriesDouble);
        return caloriesDouble.intValue();

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
