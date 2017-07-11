package com.example.vicky.drinktracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Calendar;
import java.util.Date;

public class DrinkEventDetails extends AppCompatActivity {

    TextView detailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_event_details);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String myDrinks = sharedPref.getString("MyDrinks", "");

        Gson gson = new Gson();
        DrinkEventCollection drinkEventCollection = gson.fromJson(myDrinks, DrinkEventCollection.class);

        detailText = (TextView)findViewById(R.id.details);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

//        String date = extras.getString("date");
        String type = extras.getString("type");
        String cost = extras.getString("cost");
        String volume = extras.getString("volume");
        String strength = extras.getString("strength");

        detailText.setText("Date Event:  " + "You had a drink of " + type + ", " + "that cost £" + cost + ", and was" + volume + "ml" + ", with an abv of " + strength);
    }
}

//TODO display the extras send with the intent when submit add drink event
//intent.putExtra("date", date);
//        intent.putExtra("type", this.selectedDrinkType);
//        intent.putExtra("cost", cost);
//        intent.putExtra("volume", volume);
//        intent.putExtra("strength", strength);