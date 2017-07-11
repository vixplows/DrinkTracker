package com.example.vicky.drinktracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DrinkEventDetails extends AppCompatActivity {

    Button calculateUnitsButton;
    TextView unitsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_event_details);

        calculateUnitsButton = (Button)findViewById(R.id.calculate_units);
        unitsTextView = (TextView)findViewById(R.id.units);
    }
}
