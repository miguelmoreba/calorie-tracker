package com.codeclan.calorietracker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.codeclan.calorietracker.DB.DatabaseHelper;
import com.codeclan.calorietracker.Models.Food;
import com.codeclan.calorietracker.Adapters.FoodAdapter;
import com.codeclan.calorietracker.R;

import java.util.ArrayList;

public class DisplayData extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_data);

        myDb = new DatabaseHelper(this);
        ListView listView = findViewById(R.id.list);

        ArrayList<Food> foodArrayList= myDb.getAllData();
        
        FoodAdapter foodAdapter = new FoodAdapter(this, foodArrayList);

        listView.setAdapter(foodAdapter);
    }

    public void onDeleteClick(View view) {
        Food selectedFood = (Food) view.getTag();

        myDb.deleteData(selectedFood.getId());

        ArrayList<Food> foodArrayList= myDb.getAllData();

        FoodAdapter foodAdapter = new FoodAdapter(this, foodArrayList);
        
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(foodAdapter);


    }

    public void onEditClick(View view) {
        Intent intent = new Intent(this, UpdateActivity.class);
        Food selectedFood = (Food) view.getTag();

        intent.putExtra("food", selectedFood);
        startActivity(intent);
    }
}
