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
    private String date;
    private Meal meal;

    public Food(String name, Double proteins, Double carbs, Double fats) {  // Constructor for when you don't need ID (without date or meal)
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.calories = createCalories();
    }



    public Food(int id, String name, Double proteins, Double carbs, Double fats) {   // Constructor for when you need ID (without date or meal)
        this.name = name;
        this.id = id;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.calories = createCalories();
    }

    public Food(int id, String name, Double proteins, Double carbs, Double fats, String date, Meal meal) {
        this.id = id;
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.date = date;
        this.meal = meal;
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

    public Integer getCalories(){
        return this.calories;
    }

    public String toString() {
        return "This food item is " + getName() + " and has prot: " + getProteins();
    }




}
