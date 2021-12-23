package npc;

import location.Tracker;

public abstract class Animal extends Tracker {

    private String name;

    public Animal(String name) {
        this.name = name;
    }
}
