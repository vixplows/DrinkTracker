package com.example.vicky.drinktracker;

/**
 * Created by vicky on 10/07/2017.
 */

public class Drink {

    private DrinkType type;
    private double cost;
    private double volume;
    private double strength;

    public Drink(DrinkType type, double cost, double volume, double strength) {
        this.type = type;
        this.cost = cost;
        this.volume = volume;
        this.strength = strength;
    }

    public DrinkType getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }

    public double getVolume() {
        return volume;
    }

    public double getStrength() {
        return strength;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

}
