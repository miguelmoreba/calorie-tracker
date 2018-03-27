package com.codeclan.calorietracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by miguelmorenobaladron on 3/27/18.
 */

public class FoodAdapter extends ArrayAdapter<Food> {

    public FoodAdapter(Context context, ArrayList<Food> list){
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){
        Food currentFood = getItem(position);
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        TextView name = listItemView.findViewById(R.id.name);
        name.setText(currentFood.getName().toString());

        TextView proteins = listItemView.findViewById(R.id.proteins);
        proteins.setText(currentFood.getProteins().toString());

        TextView carbs = listItemView.findViewById(R.id.carbs);
        carbs.setText(currentFood.getCarbs().toString());

        TextView fats = listItemView.findViewById(R.id.fats);
        fats.setText(currentFood.getFats().toString());

        listItemView.setTag(currentFood);

        return listItemView;
    }
}
