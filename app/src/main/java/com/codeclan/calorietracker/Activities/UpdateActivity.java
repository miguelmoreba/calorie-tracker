package com.codeclan.calorietracker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.codeclan.calorietracker.DB.DatabaseHelper;
import com.codeclan.calorietracker.Models.Food;
import com.codeclan.calorietracker.R;

public class UpdateActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText updateName, updateProteins, updateCarbs, updateFats;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myDB = new DatabaseHelper(this);

        food = (Food) getIntent().getSerializableExtra("food");

        updateName = (EditText)findViewById(R.id.updateName_Update);
        updateName.setText(food.getName().toString());

        updateProteins = (EditText)findViewById(R.id.numberbox_proteins);
        updateProteins.setText(food.getProteins().toString());

        updateCarbs = (EditText)findViewById(R.id.numberbox_carbs);
        updateCarbs.setText(food.getCarbs().toString());

        updateFats = (EditText)findViewById(R.id.numberbox_fats);
        updateFats.setText(food.getFats().toString());



    }

    public void onUpdateButtonClick(View view){
       String updatedName = updateName.getText().toString();
       Double updatedProteins = Double.parseDouble(updateProteins.getText().toString());
       Double updatedCarbs = Double.parseDouble(updateCarbs.getText().toString());
       Double updatedFats = Double.parseDouble(updateFats.getText().toString());

       Food food = new Food(this.food.getId(), updatedName, updatedProteins, updatedCarbs, updatedFats);


        boolean isInserted =  myDB.editData(food);
        System.out.println("True or false?: " + isInserted);
        if (isInserted == true)
            Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(UpdateActivity.this, "Not updated", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, DisplayData.class);
        startActivity(intent);   //This takes you to a fresh view all data page so the info the user views is actually updated

    }
}
