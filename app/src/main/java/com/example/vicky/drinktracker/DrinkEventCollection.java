package com.example.vicky.drinktracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkEventCollection {

    private HashMap<String, ArrayList<DrinkEvent>> drinkEventCollection = new HashMap<String, ArrayList<DrinkEvent>>();

    public DrinkEventCollection() {

        DrinkEvent drinkEvent;
        DrinkEvent drinkEventA;
        Drink drink;
        Drink drinkA;

        drink = new Drink(DrinkType.WINE, 4.50, 250, 12.5);
        drinkA = new Drink(DrinkType.BEER, 5.00, 330, 5.0);

        Calendar date = new GregorianCalendar();
        Calendar dateA = new GregorianCalendar();
        date.set(2017, 6, 10);
        dateA.set(2017, 6, 9);

        drinkEvent = new DrinkEvent(date, drink);
        drinkEventA = new DrinkEvent(dateA, drinkA);

        String key = drinkEvent.getKey();
        String keyA = drinkEventA.getKey();

        ArrayList<DrinkEvent> eventList = new ArrayList<DrinkEvent>();
        eventList.add(drinkEvent);

        ArrayList<DrinkEvent> eventListA = new ArrayList<DrinkEvent>();
        eventList.add(drinkEventA);

        this.drinkEventCollection.put(key, eventList);
        this.drinkEventCollection.put(keyA, eventListA);
    }

    public void addDrinkEvent(DrinkEvent event) {
        //check if the key exists in the HashMap
        //if not then initialise a new ArrayList
        //add the DrinkEvent to the ArrayList
    }

    public HashMap getCollection() {
        return this.drinkEventCollection;
    }
}



