package com.example.vicky.drinktracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    Button addDrinkButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDrinkButton = (Button) findViewById(R.id.add_drink_button);

        ListView l = (ListView) findViewById(R.id.drinks_list);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String myDrinks = sharedPref.getString("MyDrinks", "");


        Gson gson = new Gson();

        DrinkEventCollection drinkEventCollection = gson.fromJson(myDrinks, DrinkEventCollection.class);
        if (drinkEventCollection == null) drinkEventCollection = new DrinkEventCollection();

        ArrayList<String> myDrinksList = drinkEventCollection.showDateDrinkTotal();
        Log.d("mydrinks is ", myDrinksList.toString());

        DrinkEventCollectionAdapter deca = new DrinkEventCollectionAdapter(this, myDrinksList);
        l.setAdapter(deca);

    }

    public void onAddDrinkButtonClicked(View button) {
        Intent intent = new Intent(MainActivity.this, AddDrinkActivity.class);
        startActivity(intent);

        Log.d(getClass().toString(), "onAddDrinkButtonClicked was called");
    }
}