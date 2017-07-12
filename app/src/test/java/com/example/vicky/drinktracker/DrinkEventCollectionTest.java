package com.example.vicky.drinktracker;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkEventCollectionTest {

    DrinkEventCollection drinkEventCollection;
    DrinkEvent drinkEvent;
    DrinkEvent drinkEventA;
    DrinkEvent drinkEventB;
    Drink drink;
    Drink drinkA;
    Drink drinkB;

    @Before
    public void before() {
        drinkEventCollection = new DrinkEventCollection();

        drink = new Drink(DrinkType.WINE, 4.50, 250, 12.5);
        drinkA = new Drink(DrinkType.BEER, 5.00, 330, 5.0);
        drinkB = new Drink(DrinkType.SPIRIT, 3.50, 50, 40);

        Calendar date = new GregorianCalendar();
        Calendar dateA = new GregorianCalendar();
        date.set(2017, 6, 10);
        dateA.set(2017, 6, 9);

        drinkEvent = new DrinkEvent(date, drink);
        drinkEventA = new DrinkEvent(dateA, drinkA);
        drinkEventB = new DrinkEvent(dateA, drinkB);
    }

    @Test
    public void canCheckCollectionSize() {
        drinkEventCollection.addDrinkEvent(drinkEvent);
        drinkEventCollection.addDrinkEvent(drinkEventA);
        HashMap allDrinkEvents = drinkEventCollection.getDrinkEventHashMap();
        assertEquals(2, allDrinkEvents.size());
    }

    @Test
    public void canGetDrinkEventHashMap() {
        drinkEventCollection.addDrinkEvent(drinkEventB);
        assertEquals(1, drinkEventCollection.getDrinkEventHashMap().size());
    }

    @Test
    public void canGetDrinkDateList() {
        drinkEventCollection.addDrinkEvent(drinkEvent);
        drinkEventCollection.addDrinkEvent(drinkEventA);
        drinkEventCollection.addDrinkEvent(drinkEventB);
        assertEquals(2, drinkEventCollection.getDrinkDateList().size());
    }

}
