package com.example.vicky.drinktracker;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.value;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkEventCollection {

    private HashMap<String, ArrayList<DrinkEvent>> drinkEventCollection = new HashMap<String, ArrayList<DrinkEvent>>();

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

//    public ArrayList<DrinkEvent> getDateDrinks() {
//        // aim to display date with total number of DrinkEvents on that day
        // first need method that provides TotalNumberOfDrinkEvents for a single date
        // and then method that can loop through so that for keys that exist in hashmap return size of the value(ArrayList)

//    }
}


