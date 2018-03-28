package com.codeclan.calorietracker;

import com.codeclan.calorietracker.Models.Food;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by miguelmorenobaladron on 3/28/18.
 */

public class FoodTest {

    Food food;

    @Before
    public void before(){
        this.food = new Food("Egg", 6.3, 0.4, 4.8);
    }

    @Test
    public void hasCorrectCalories(){
        int calories = food.createCalories();
        assertEquals(70, calories);
    }


}
