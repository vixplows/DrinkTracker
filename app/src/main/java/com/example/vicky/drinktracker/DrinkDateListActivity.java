package com.example.vicky.drinktracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class DrinkDateListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks_list);

        ListView l = (ListView) findViewById(R.id.drinks_list);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String myDrinks = sharedPref.getString("MyDrinks", "");

        Gson gson = new Gson();
        DrinkEventCollection drinkEventCollection = gson.fromJson(myDrinks, DrinkEventCollection.class);
        if (drinkEventCollection == null) drinkEventCollection = new DrinkEventCollection();

        ArrayList<String> myDrinksList = drinkEventCollection.getList();

        DrinkEventCollectionAdapter deca = new DrinkEventCollectionAdapter(this, myDrinksList);
        l.setAdapter(deca);
    }

}