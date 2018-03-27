package com.codeclan.calorietracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by miguelmorenobaladron on 3/26/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tracker.db";
    public static final String TABLE_NAME = "foods";
    public static final String COL_1= "ID";
    public static final String COL_2= "NAME";
    public static final String COL_3= "PROTEINS";
    public static final String COL_4= "CARBS";
    public static final String COL_5= "FATS";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PROTEINS DOUBLE, CARBS DOUBLE, FATS DOUBLE)");
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      onCreate(db);
    }

    public boolean insertData(String name, String proteins, String carbs, String fats){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, proteins);
        contentValues.put(COL_4, carbs);
        contentValues.put(COL_5, fats);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public ArrayList<Food> getAllData(){

        ArrayList<Food> allFoods = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        res.moveToFirst();

        while(res.moveToNext()) {
            String name = res.getString(1);
            Double proteins = res.getDouble(2);
            Double carbs = res.getDouble(3);
            Double fats = res.getDouble(4);

            Food food = new Food(name, proteins, carbs, fats);

            allFoods.add(food);
        }

        return allFoods;

    }
}
