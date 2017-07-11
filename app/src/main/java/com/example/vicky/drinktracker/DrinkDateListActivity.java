package com.example.vicky.drinktracker;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DrinkDateListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks_list);

        ListView l = (ListView) findViewById(R.id.drinks_list);

        DrinkEventCollection dr = new DrinkEventCollection();
        ArrayList<String> myDrinks = dr.getList();

        DrinkEventCollectionAdapter deca = new DrinkEventCollectionAdapter(this, myDrinks);
        l.setAdapter(deca);
    }

}