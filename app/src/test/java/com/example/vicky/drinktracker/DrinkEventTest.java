package com.example.vicky.drinktracker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkEventTest {

    DrinkEvent drinkEvent;
    Drink drink;

    @Before
    public void before() {
        drink = new Drink(DrinkType.WINE, 4.50, 250, 12.5);
        Calendar date = new GregorianCalendar();
        date.set(2017, 6, 10);
        drinkEvent = new DrinkEvent(date, drink);
    }

    @Test
    public void getDateTest() {
        Calendar date = drinkEvent.getDate();
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);
        assertEquals(10, day);
        assertEquals(6, month);
        assertEquals(2017, year);
    }

    @Test
    public void getDrink() {
        Drink drink = drinkEvent.getDrink();
        DrinkType type = drink.getType();
        double cost = drink.getCost();
        double volume = drink.getVolume();
        double strength = drink.getStrength();
        assertEquals(DrinkType.WINE, type);
        assertEquals(4.50, cost, .01);
        assertEquals(250, volume, .01);
        assertEquals(12.5, strength, .01);
    }

    @Test
    public void getKey() {
        String key = drinkEvent.getKey();
        assertEquals("10/07/2017", key);
    }
}
