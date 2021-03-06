package com.example.vicky.drinktracker;

import android.content.Context;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkEvent{

    private Calendar date;
    private Drink drink;

    public DrinkEvent(Calendar date, Drink drink) {
        this.date = date;
        this.drink = drink;
    }

    public Calendar getDate() {
        return date;
    }

    public Drink getDrink() {
        return drink;
    }

    public String getKey() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String key = dateFormat.format(this.date.getTime());
        return key;
    }
}
