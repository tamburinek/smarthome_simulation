package npc;

import devices.Device;
import enums.Gender;
import house.House;
import location.Tracker;

public abstract class Human extends Tracker {

    private String name;
    private int age;
    private Gender gender;
    private House house;

    private int happiness;
    private int health;
    private int clean;

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
