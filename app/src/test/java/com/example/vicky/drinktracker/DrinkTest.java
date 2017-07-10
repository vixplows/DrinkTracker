package com.example.vicky.drinktracker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by vicky on 10/07/2017.
 */

public class DrinkTest {

    Drink drink;

    @Before
    public void before() {
        drink = new Drink(DrinkType.WINE, 4.50, 250, 12.5);
    }

    @Test
    public void getTypeTest() {
        assertEquals(DrinkType.WINE, drink.getType());
    }

    @Test
    public void getCostTest() {
        assertEquals(4.50, drink.getCost(), .01);
    }

    @Test
    public void getVolumeTest() {
        assertEquals(250, drink.getVolume(), .01);
    }

    @Test
    public void getStrengthTest() {
        assertEquals(12.5, drink.getStrength(), .01);
    }

    @Test
    public void setTypeTest() {
        drink.setType(DrinkType.SPIRIT);
        assertEquals(DrinkType.SPIRIT, drink.getType());
    }

}
