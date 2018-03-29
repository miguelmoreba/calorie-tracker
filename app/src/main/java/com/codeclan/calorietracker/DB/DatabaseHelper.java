package com.codeclan.calorietracker.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codeclan.calorietracker.Models.Food;

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
//    public static final String COL_6= "DATE";
//    public static final String COL_7= "MEAL";


    //ISO8601
    //YYYY-MM-DD

    //smdf = newSimpleDateFormat("YYYY-MM-DD)"
    //smdf.parse(date)

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
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

    public boolean insertData(Food food){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, food.getName());
        contentValues.put(COL_3, food.getProteins());
        contentValues.put(COL_4, food.getCarbs());
        contentValues.put(COL_5, food.getFats());
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public ArrayList<Food> getFoodByDate(String date) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE date = " + date;

        ArrayList<Food> allFoods = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(sql, null);

        res.moveToFirst();

        while(res.moveToNext()) {
            int id = res.getInt(0);
            String name = res.getString(1);
            Double proteins = res.getDouble(2);
            Double carbs = res.getDouble(3);
            Double fats = res.getDouble(4);

            Food food = new Food(id, name, proteins, carbs, fats);

            allFoods.add(food);
        }

        return allFoods;

    }

    public ArrayList<String> getAllDates() {
        String sql = "SELECT date from " + TABLE_NAME + " GROUP BY date";
        ArrayList<String> dates = new ArrayList<>();

        dates.add("2018-01-01");
        dates.add("2018-01-02");

        return dates;
    }

    public ArrayList<Food> getAllData(){

        ArrayList<Food> allFoods = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        while(res.moveToNext()) {

            int id = res.getInt(0);
            String name = res.getString(1);
            Double proteins = res.getDouble(2);
            Double carbs = res.getDouble(3);
            Double fats = res.getDouble(4);

            Food food = new Food(id, name, proteins, carbs, fats);

            allFoods.add(food);
        }

        return allFoods;

    }

    public boolean editData(Food food){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, food.getName());
        contentValues.put(COL_3, food.getProteins());
        contentValues.put(COL_4, food.getCarbs());
        contentValues.put(COL_5, food.getFats());

        String[] values = { String.valueOf(food.getId())  };

        int result = db.update(TABLE_NAME, contentValues, "id = ?", values );

        System.out.println("result is: " + result);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean deleteData(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        String[] values = {String.valueOf(id)};

        int result = db.delete(TABLE_NAME, "id = ?", values);

        if (result == -1)
            return false;
        else
            return true;
    }


}
