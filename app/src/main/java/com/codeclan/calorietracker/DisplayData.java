package com.codeclan.calorietracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
