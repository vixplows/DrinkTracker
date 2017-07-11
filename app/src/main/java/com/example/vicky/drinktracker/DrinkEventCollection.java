package com.example.vicky.drinktracker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkEventCollection {

    private HashMap<String, ArrayList<DrinkEvent>> drinkEventCollection = new HashMap<String, ArrayList<DrinkEvent>>();

    public DrinkEventCollection() {

        Drink drink = new Drink(DrinkType.WINE, 4.50, 250, 12.5);
        Drink drinkA = new Drink(DrinkType.BEER, 5.00, 330, 5.0);
        Drink drinkB = new Drink(DrinkType.SPIRIT, 3.50, 50, 40);

        Calendar date = new GregorianCalendar();
        Calendar dateA = new GregorianCalendar();
        date.set(2017, 6, 10);
        dateA.set(2017, 6, 9);

        DrinkEvent dr = new DrinkEvent(date, drink);
        DrinkEvent dr2 = new DrinkEvent(dateA, drinkA);
        DrinkEvent dr3 = new DrinkEvent(dateA, drinkB);

        ArrayList<DrinkEvent> drList = new ArrayList<>();
        drList.add(dr);
        drList.add(dr3);
        drList.add(dr2);

        drinkEventCollection.put("20/11/2017", drList);
        drinkEventCollection.put("22/11/2017", drList);


    }

    public void addDrinkEvent(DrinkEvent drinkEvent) {
        String key = drinkEvent.getKey();
        if (!drinkEventCollection.containsKey(key)) {
            ArrayList<DrinkEvent> eventList = new ArrayList<DrinkEvent>();
            eventList.add(drinkEvent);
            drinkEventCollection.put(key, eventList);
        } else {
            drinkEventCollection.get(key).add(drinkEvent);
        }
    }

    public HashMap getCollection() {
        return drinkEventCollection;
    }

    public int getTotalDrinkEventsOnDate(String key) {
        int listSize = drinkEventCollection.get(key).size();
        return listSize;
    }

    public ArrayList<String> getList() {
        ArrayList<String> drinkDateList = new ArrayList<>();

        for (String key : drinkEventCollection.keySet()) {
            String totalDrinks = String.valueOf(drinkEventCollection.get(key).size());
            drinkDateList.add("Date: " + key + ";  Drinks Drunk = " + totalDrinks);
        }
        return drinkDateList;
    }


}