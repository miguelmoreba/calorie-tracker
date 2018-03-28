package com.codeclan.calorietracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.codeclan.calorietracker.Models.Food;
import com.codeclan.calorietracker.R;

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

        ImageButton editButton =  listItemView.findViewById(R.id.edit_button);
        editButton.setTag(currentFood);

        ImageButton deleteButton =  listItemView.findViewById(R.id.delete_button);
        deleteButton.setTag(currentFood);
        listItemView.setTag(currentFood);

        return listItemView;
    }
}
