package npc;

import enums.Constants;
import enums.Gender;
import house.House;
import location.Tracker;

public abstract class Human extends Tracker {

    private final String name;
    private int age;
    private final Gender gender;

    private House house;

    private int happiness = Constants.START_HAPPINESS;
    private int health = Constants.START_HEALTH;
    private int clean = Constants.START_CLEAN;
    private int fresh = Constants.START_FRESH;

    public Human(String name, int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
