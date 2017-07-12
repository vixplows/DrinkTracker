package com.example.vicky.drinktracker;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import java.util.GregorianCalendar;

public class AddDrinkActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    TextView addDateEditText;
    Spinner selectTypeSpinner;
    EditText addCostEditText;
    EditText addVolumeEditText;
    EditText addStrengthEditText;
    Button submitDrinkButton;
    DrinkType selectedDrinkType;
    GregorianCalendar date = new GregorianCalendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);

        addDateEditText = (EditText)findViewById(R.id.display_date);
        selectTypeSpinner = (Spinner)findViewById(R.id.type);
        addCostEditText = (EditText)findViewById(R.id.cost);
        addVolumeEditText = (EditText)findViewById(R.id.volume);
        addStrengthEditText = (EditText)findViewById(R.id.strength);
        submitDrinkButton = (Button)findViewById(R.id.submit_drink);

        selectTypeSpinner.setOnItemSelectedListener(this);
        this.selectedDrinkType = DrinkType.BEER;

    }

    public void setDate(int year, int month, int day) {
        addDateEditText.setText(day + " - " + (month+1) + " - " + year);
        date.set(year, month, day);
    }

    public void openDatePicker(View view) {
        DialogFragment datepicker = new DatePickerFragment();
        datepicker.show(getFragmentManager(), "datePicker");
    }

    public void onSubmitDrinkEventButtonClicked(View button) {

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String myDrinks = sharedPref.getString("MyDrinks", "");

        Gson gson = new Gson();
        DrinkEventCollection drinkEventCollection = gson.fromJson(myDrinks, DrinkEventCollection.class);
        if (drinkEventCollection == null) drinkEventCollection = new DrinkEventCollection();

        addDateEditText = (EditText)findViewById(R.id.display_date);
        selectTypeSpinner = (Spinner)findViewById(R.id.type);
        addCostEditText = (EditText)findViewById(R.id.cost);
        addVolumeEditText = (EditText)findViewById(R.id.volume);
        addStrengthEditText = (EditText)findViewById(R.id.strength);

        Double cost = Double.parseDouble(addCostEditText.getText().toString());
        Double volume = Double.parseDouble(addVolumeEditText.getText().toString());
        Double strength = Double.parseDouble(addStrengthEditText.getText().toString());

        Drink drink = new Drink(this.selectedDrinkType, cost, volume, strength);

        Double units = drink.calculateUnits();

        DrinkEvent drinkEvent = new DrinkEvent(date, drink);
        drinkEventCollection.addDrinkEvent(drinkEvent);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("MyDrinks", gson.toJson(drinkEventCollection));

        editor.apply();

        Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(AddDrinkActivity.this, DrinkEventDetailsActivity.class);
        Bundle extras = new Bundle();

        extras.putString("date", String.valueOf(drinkEvent.getKey()));
        extras.putString("type", String.valueOf(this.selectedDrinkType));
        extras.putString("cost", String.valueOf(cost));
        extras.putString("volume", String.valueOf(volume));
        extras.putString("strength", String.valueOf(strength));
        extras.putString("units", String.format("%.2f", units));

        intent.putExtras(extras);

        startActivity(intent);

        Log.d(getClass().toString(), "onSubmitDrinkEventButtonClicked was called");

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String value = (String) adapterView.getItemAtPosition(i);
        this.selectedDrinkType = DrinkType.valueOf(value);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
