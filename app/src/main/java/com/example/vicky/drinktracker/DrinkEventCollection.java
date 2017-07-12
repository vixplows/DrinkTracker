package com.example.vicky.drinktracker;

import java.io.Serializable;
import java.util.ArrayList;
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

    private double totalUnitsByDay(ArrayList<DrinkEvent> drinkEvents) {
        double unitTotal = 0;

        for (DrinkEvent drinkEvent : drinkEvents) {
            unitTotal += drinkEvent.getDrink().calculateUnits();
        }
        return unitTotal;
    }

    private double totalCostByDay(ArrayList<DrinkEvent> drinkEvents) {
        double costTotal = 0;

        for (DrinkEvent drinkEvent : drinkEvents) {
            costTotal += drinkEvent.getDrink().getCost();
        }
        return costTotal;
    }

    public HashMap getDrinkEventHashMap() {
        return drinkEventHashMap;
    }

    public ArrayList<String> getDrinkDateList() {
        ArrayList<String> drinkDateList = new ArrayList<>();

        for (String key : drinkEventHashMap.keySet()) {
            ArrayList<DrinkEvent> drinkEvents = drinkEventHashMap.get(key);
            String totalDrinks = String.valueOf(drinkEvents.size());
            String totalUnits = String.format("%.2f", this.totalUnitsByDay(drinkEvents));
            String costTotal = String.valueOf(this.totalCostByDay(drinkEvents));
            drinkDateList.add(key + ": Drinks: " + totalDrinks + " (units = " + totalUnits + ") " + "Spent: £" + costTotal);
        }
        return drinkDateList;
    }

}
