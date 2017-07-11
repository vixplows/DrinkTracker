package com.example.vicky.drinktracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

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

    //public ArrayList<DrinkEvent> getListDateDrinks() {
        // display date with total number of DrinkEvents as list [need new drinkDateList class? for this?]
        // need method that provides TotalNumberOfDrinkEvents for a single date, which can be got from the size of the ArrayList sotred with that key/date
        // need to then loop throught the current hashmap to return the date(key) and the size of the associatd value(ArrayList)

    //}


}


