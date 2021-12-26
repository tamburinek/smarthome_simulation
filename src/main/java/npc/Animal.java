package npc;

import enums.Constants;
import house.House;
import location.Tracker;

public abstract class Animal extends Tracker {

    private String name;
    private House house;

    private int happiness = Constants.START_HAPPINESS;
    private int hungry = Constants.START_HUNGRY;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
