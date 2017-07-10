package com.example.vicky.drinktracker;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkEventCollectionTest {

    @Test
    public void canCheckCollectionSize() {
        DrinkEventCollection drinkEventCollection = new DrinkEventCollection();
        HashMap allDrinkEvents = drinkEventCollection.getCollection();
        assertEquals(2, allDrinkEvents.size());
    }

}
