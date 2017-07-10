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

    HashMap<String, ArrayList<DrinkEvent>> drinkEventCollection;

    public void DrinkEventCollection() {

        this.drinkEventCollection = new HashMap<String, ArrayList<DrinkEvent>>();

        DrinkEvent drinkEvent;
        DrinkEvent drinkEventA;
        Drink drink;
        Drink drinkA;

        drink = new Drink(DrinkType.WINE, 4.50, 250, 12.5);
        drinkA = new Drink(DrinkType.BEER, 5.00, 330, 5.0);

        Calendar date = new GregorianCalendar();
        date.set(2017, 6, 10);

        drinkEvent = new DrinkEvent(date, drink);
        drinkEventA = new DrinkEvent(date, drinkA);

        drinkEventCollection.put("10-7-2017", new ArrayList<DrinkEvent>(Arrays.asList(drinkEvent, drinkEventA)));
        drinkEventCollection.put("9-7-2017", new ArrayList<DrinkEvent>(Arrays.asList(drinkEvent)));
    }


    public int getCollectionSize() {
        return drinkEventCollection.size();
    }

}



