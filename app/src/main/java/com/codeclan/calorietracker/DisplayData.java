package com.codeclan.calorietracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

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
}
