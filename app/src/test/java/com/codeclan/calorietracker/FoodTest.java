package com.codeclan.calorietracker;

import com.codeclan.calorietracker.Models.Food;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by miguelmorenobaladron on 3/28/18.
 */

public class FoodTest {

    Food food;
    Food foodWithMealAndDate;

    @Before
    public void before(){

//        Date date = new Date();
//        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
//        dateFormatter.format(date);
        this.food = new Food("Egg", 6.3, 0.4, 4.8);
//        this.foodWithMealAndDate = new Food("Egg", 6.3, 0.4, 4.8, )

    }


    @Test
    public void hasCorrectCalories(){
        int calories = food.createCalories();
        assertEquals(70, calories);
    }


}
