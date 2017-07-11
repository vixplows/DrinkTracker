package com.example.vicky.drinktracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkEventCollection implements Serializable {

    private HashMap<String, ArrayList<DrinkEvent>> drinkEventHashMap = new HashMap<String, ArrayList<DrinkEvent>>();

    public void addDrinkEvent(DrinkEvent drinkEvent) {
        String key = drinkEvent.getKey();
        if (!drinkEventHashMap.containsKey(key)) {
            ArrayList<DrinkEvent> eventList = new ArrayList<DrinkEvent>();
            eventList.add(drinkEvent);
            drinkEventHashMap.put(key, eventList);
        } else {
            drinkEventHashMap.get(key).add(drinkEvent);
        }
    }

    public HashMap getDrinkEventHashMap() {
        return drinkEventHashMap;
    }

    public int getTotalDrinkEventsOnDate(String key) {
        int listSize = drinkEventHashMap.get(key).size();
        return listSize;
    }

    public ArrayList<String> getList() {
        ArrayList<String> drinkDateList = new ArrayList<>();

        for (String key : drinkEventHashMap.keySet()) {
            String totalDrinks = String.valueOf(drinkEventHashMap.get(key).size());
            drinkDateList.add("Date: " + key + ";  Drinks Drunk = " + totalDrinks);
        }
        return drinkDateList;
    }


}