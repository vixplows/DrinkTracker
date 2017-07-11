package com.example.vicky.drinktracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import com.google.gson.Gson;

public class DrinkEventDetails extends AppCompatActivity {

    TextView displayDate;
    TextView displayType;
    TextView displayCost;
    TextView displayVolume;
    TextView displayStrength;
    TextView displayUnits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_event_details);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String myDrinks = sharedPref.getString("MyDrinks", "");

        Gson gson = new Gson();
        DrinkEventCollection drinkEventCollection = gson.fromJson(myDrinks, DrinkEventCollection.class);

        displayDate = (TextView)findViewById(R.id.display_date);
        displayType = (TextView)findViewById(R.id.display_type);
        displayCost = (TextView)findViewById(R.id.display_cost);
        displayVolume = (TextView)findViewById(R.id.display_volume);
        displayStrength = (TextView)findViewById(R.id.display_strength);
        displayUnits = (TextView)findViewById(R.id.display_units);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        String date = extras.getString("date");
        String type = extras.getString("type");
        String cost = extras.getString("cost");
        String volume = extras.getString("volume");
        String strength = extras.getString("strength");
        String units = extras.getString("units");

        displayDate.setText("Date: " + date);
        displayType.setText("Type: " + type);
        displayCost.setText("Cost: £" + cost);
        displayVolume.setText("Volume: " + volume +" ml");
        displayStrength.setText("Strength: " + strength +" abv");
        displayUnits.setText("Units: " + units);

    }
}