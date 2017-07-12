package com.example.vicky.drinktracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vicky on 11/07/2017.
 */

public class DrinkEventCollectionAdapter extends ArrayAdapter<String> {
    public DrinkEventCollectionAdapter(Context context, ArrayList<String> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.drinks_item, parent, false);
        }

        TextView textView = listItemView.findViewById(R.id.date_drinks);

        String s = getItem(position);

        textView.setText(s);

        return listItemView;
    }

}