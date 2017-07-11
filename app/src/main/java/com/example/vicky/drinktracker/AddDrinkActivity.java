package com.example.vicky.drinktracker;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddDrinkActivity extends AppCompatActivity {

    EditText addDateEditText;
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
        //TODO here before lunch.

    }

    public void setDate(int year, int month, int day) {
        addDateEditText.setText(day + " - " + month + " - " + year);
    }

    public void openDatePicker(View view) {
        DialogFragment datepicker = new DatePickerFragment();
        datepicker.show(getFragmentManager(), "datePicker");
    }
}
