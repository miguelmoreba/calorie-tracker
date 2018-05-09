package com.codeclan.calorietracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

import com.codeclan.calorietracker.Models.Meal;
import com.codeclan.calorietracker.R;

import java.util.ArrayList;

/**
 * Created by miguelmorenobaladron on 3/29/18.
 */

public class MealAdapter extends ArrayAdapter<Meal> {

    public MealAdapter(Context context, ArrayList<Meal> list){
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        CheckedTextView text = (CheckedTextView) convertView;
        Meal currentMeal = getItem(position);

        if (text == null){
            text = (CheckedTextView) LayoutInflater.from(getContext()).inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);

            text.setText(currentMeal.values().toString());
        }
        return text;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        CheckedTextView text = (CheckedTextView) convertView;
        Meal currentMeal = getItem(position);

        if (text == null) {
            text = (CheckedTextView) LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item,  parent, false);
        }

        text.setText(currentMeal.values().toString());

        return text;
    }
}
