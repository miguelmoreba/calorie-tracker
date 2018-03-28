package com.codeclan.calorietracker.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codeclan.calorietracker.DB.DatabaseHelper;
import com.codeclan.calorietracker.Models.Food;
import com.codeclan.calorietracker.R;

public class EditDataActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editName, editProteins, editCarbs, editFats;
    Food food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        food = (Food) getIntent().getSerializableExtra("food");

        

        editName = (EditText)findViewById(R.id.editName_update);
        editName.setText(food.getName());

        editProteins = (EditText)findViewById(R.id.editProtein_update);
        editProteins.setText(food.getProteins().toString());

        editCarbs = (EditText)findViewById(R.id.editCarbs_update);
        editCarbs.setText(food.getCarbs().toString());

        editFats = (EditText)findViewById(R.id.editFats_update);
        editFats.setText(food.getFats().toString());


    }

    public void onUpdateClick(View view) {
        String updatedName = editName.getText().toString();
        Double updatedProteins = Double.parseDouble(editProteins.getText().toString());
        Double updatedCarbs = Double.parseDouble(editCarbs.getText().toString());
        Double updatedFats = Double.parseDouble(editFats.getText().toString());

        Food food = new Food(this.food.getId(), updatedName, updatedProteins, updatedCarbs, updatedFats);

        boolean isInserted = myDB.editData(food);
        if (isInserted == true)
            Toast.makeText(EditDataActivity.this, "Updated", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(EditDataActivity.this, "Not updated", Toast.LENGTH_LONG).show();
    }


}
