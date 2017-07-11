package com.example.vicky.drinktracker;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AddDrinkActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView addDateEditText;
    Spinner selectTypeSpinner;
    EditText addCostEditText;
    EditText addVolumeEditText;
    EditText addStrengthEditText;
    Button submitDrinkButton;
    DrinkType selectedDrinkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);

        addDateEditText = (EditText)findViewById(R.id.date);
        selectTypeSpinner = (Spinner)findViewById(R.id.type);
        addCostEditText = (EditText)findViewById(R.id.cost);
        addVolumeEditText = (EditText)findViewById(R.id.volume);
        addStrengthEditText = (EditText)findViewById(R.id.strength);
        submitDrinkButton = (Button)findViewById(R.id.submit_drink);

        selectTypeSpinner.setOnItemSelectedListener(this);
        this.selectedDrinkType = DrinkType.BEER;

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

        // TODO need to add calculate method here? OR move to DrinkEvent Details activity
        // so not part of the form. If move - remove references to widgets in this activity
        // and also from the xml file

        Log.d(getClass().toString(), "onCalculateUnitsButtonClicked was called");

    }

    // save drink event details
    public void saveDrinkEventDetails(View view) {
        SharedPreferences sharedPref = getSharedPreferences("drinkEventDetails", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("Date", addDateEditText.getText().toString());
        int selectedPosition = selectTypeSpinner.getSelectedItemPosition();
        editor.putInt("Type", selectedPosition);
        editor.putString("Volume", addVolumeEditText.getText().toString());
        editor.putString("Strength", addStrengthEditText.getText().toString());

        //TODO where commiting to - DrinkEventSdetails? using the .add method?
        editor.commit();


        //TODO is this showing?
        Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();

    }

    // Print out saved data
    public void showDetails(View view) {
        SharedPreferences sharedPref = getSharedPreferences("drinkEventDetails", Context.MODE_PRIVATE);

        String date = sharedPref.getString ("Date", "");
        String type = sharedPref.getString("Type", "");
        String volume = sharedPref.getString("Volume", "");
        String strength = sharedPref.getString("Strength", "");
        String units = sharedPref.getString("Units", "");

        // TODO do this on a new activity page DrinkEventDetails?
//        eventDetails.setText(Date + "" + Type)
    }

    public void onSubmitDrinkEventButtonClicked(View button) {
        Intent intent = new Intent(AddDrinkActivity.this, DrinkEventDetails.class);
        startActivity(intent);

        Log.d(getClass().toString(), "onSubmitDrinkEventButtonClicked was called");

    }

    //TODO This is to get back an enum from the spinner - where using it?
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String value = (String) adapterView.getItemAtPosition(i);
        this.selectedDrinkType = DrinkType.valueOf(value);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
