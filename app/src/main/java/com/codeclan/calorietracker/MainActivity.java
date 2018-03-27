package com.codeclan.calorietracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editFood, editProteins, editCarbs, editFats;
    Button btnaddData;
    Button btnviewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

        editFood = (EditText)findViewById(R.id.editText_food);
        editProteins = (EditText)findViewById(R.id.editText_proteins);
        editCarbs = (EditText)findViewById(R.id.editText_carbs);
        editFats = (EditText)findViewById(R.id.editText_fats);
        btnaddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
    }

    public void onAddButtonClick(View view){
        boolean isInserted = myDB.insertData(editFood.getText().toString(),
                editProteins.getText().toString(),
                editCarbs.getText().toString(),
                editFats.getText().toString());
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
