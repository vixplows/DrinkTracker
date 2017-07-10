package com.example.vicky.drinktracker;

import java.util.Calendar;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkEvent {

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
}
