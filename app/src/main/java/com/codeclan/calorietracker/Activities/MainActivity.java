package com.codeclan.calorietracker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.codeclan.calorietracker.Adapters.MealAdapter;
import com.codeclan.calorietracker.DB.DatabaseHelper;
import com.codeclan.calorietracker.Models.Food;
import com.codeclan.calorietracker.Models.Meal;
import com.codeclan.calorietracker.R;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editFood, editProteins, editCarbs, editFats;
    Button btnaddData;
    Button btnviewAll;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

        editFood = (EditText)findViewById(R.id.editText_food);
        editProteins = (EditText)findViewById(R.id.editText_proteins);
        editCarbs = (EditText)findViewById(R.id.editText_carbs);
        editFats = (EditText)findViewById(R.id.editText_fats);
        btnaddData = (Button)findViewById(R.id.button_update);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
//        spinner = (Spinner)findViewById(R.id.spinner_create);
//        spinner.setAdapter(new MealAdapter(this, R.layout.support_simple_spinner_dropdown_item, Meal.BR));
    }

    public void onAddButtonClick(View view){
        Double proteins = Double.parseDouble(editProteins.getText().toString());
        Double carbs = Double.parseDouble(editCarbs.getText().toString());
        Double fats = Double.parseDouble(editFats.getText().toString());
        Food food = new Food(editFood.getText().toString(), proteins, carbs, fats);
        boolean isInserted = myDB.insertData(food);
        if(isInserted == true)
            Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();

    }

    public void onViewAllButtonClick(View view){
        Intent intent = new Intent(this, DisplayData.class);
        startActivity(intent);
    }

    
}
