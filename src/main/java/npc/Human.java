package npc;

import location.Tracker;

public abstract class Human extends Tracker {

    private String name;
    private int age;

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
