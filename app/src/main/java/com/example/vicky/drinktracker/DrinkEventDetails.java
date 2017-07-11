package com.example.vicky.drinktracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DrinkEventDetails extends AppCompatActivity {

//    Button calculateUnitsButton;
//    TextView unitsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_event_details);


        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String myDrinks = sharedPref.getString("MyDrinks", "");

        Gson gson = new Gson();
        DrinkEventCollection drinkEventCollection = gson.fromJson(myDrinks, DrinkEventCollection.class);

        //TODO tuesday night / wednesday morning display information


//        calculateUnitsButton = (Button)findViewById(R.id.calculate_units);
//        unitsTextView = (TextView)findViewById(R.id.units);


    }
}
