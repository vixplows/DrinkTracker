package com.example.vicky.drinktracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addDrinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDrinkButton = (Button)findViewById(R.id.add_drink_button);

        ListView l = (ListView) findViewById(R.id.drinks_list);

        DrinkEventCollection dr = new DrinkEventCollection();
        ArrayList<String> myDrinks = dr.getList();

        DrinkEventCollectionAdapter deca = new DrinkEventCollectionAdapter(this, myDrinks);
        l.setAdapter(deca);
    }

    public void onAddDrinkButtonClicked(View button) {
        Intent intent = new Intent(MainActivity.this, AddDrinkActivity.class);
        startActivity(intent);

        Log.d(getClass().toString(), "onAddDrinkButtonClicked was called");
    }
}
