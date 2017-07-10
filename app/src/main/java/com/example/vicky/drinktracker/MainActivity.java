package com.example.vicky.drinktracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addDrinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDrinkButton = (Button)findViewById(R.id.add_drink_button);
    }

    public void onAddDrinkButtonClicked(View button) {
        Intent intent = new Intent(MainActivity.this, AddDrinkActivity.class);
        startActivity(intent);

        Log.d(getClass().toString(), "onAddDrinkButtonClicked was called");
    }
}
