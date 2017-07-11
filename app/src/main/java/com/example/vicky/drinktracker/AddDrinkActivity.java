package com.example.vicky.drinktracker;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddDrinkActivity extends AppCompatActivity {

    TextView addDateEditText;
    EditText selectTypeEditText;
    EditText addCostEditText;
    EditText addVolumeEditText;
    EditText addStrengthEditText;
    Button calculateUnitsButton;
    TextView unitsTextView;
    Button submitDrinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);

        addDateEditText = (EditText)findViewById(R.id.date);
        selectTypeEditText = (EditText)findViewById(R.id.type);
        addCostEditText = (EditText)findViewById(R.id.cost);
        addVolumeEditText = (EditText)findViewById(R.id.volume);
        addStrengthEditText = (EditText)findViewById(R.id.strength);
        calculateUnitsButton = (Button)findViewById(R.id.calculate_units);
        unitsTextView = (TextView)findViewById(R.id.units);
        submitDrinkButton = (Button)findViewById(R.id.submit_drink);
        //TODO here before lunch.

    }

    public void setDate(int year, int month, int day) {
        addDateEditText.setText(day + " - " + month + " - " + year);
    }

    public void openDatePicker(View view) {
        DialogFragment datepicker = new DatePickerFragment();
        datepicker.show(getFragmentManager(), "datePicker");
    }

    public void onCalculateUnitsButtonClicked(View button) {
        Intent intent = new Intent(AddDrinkActivity.this, AddDrinkActivity.class);
        startActivity(intent);

        Log.d(getClass().toString(), "onCalculateUnitsButtonClicked was called");

    }

    public void onSubmitDrinkEventButtonClicked(View button) {
        Intent intent = new Intent(AddDrinkActivity.this, MainActivity.class);
        startActivity(intent);

        Log.d(getClass().toString(), "onSubmitDrinkEventButtonClicked was called");

    }
}
