package com.codeclan.calorietracker.Models;

/**
 * Created by miguelmorenobaladron on 3/29/18.
 */

public enum Meal {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACKS("Snacks");

    private String friendlyName;

    Meal(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString(){
        return friendlyName;
    }
    

}
