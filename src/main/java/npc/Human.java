package npc;

import house.House;
import location.Tracker;

public abstract class Human extends Tracker {

    private String name;
    private int age;
    private House house;

    public Human(String name, int age){
        this.name = name;
        this.age = age;
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
