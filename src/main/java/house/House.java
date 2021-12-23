package house;

import npc.Animal;
import npc.Human;

import java.util.ArrayList;

public class House {

    private String houseName;
    private ArrayList<Floor> floors;
    private ArrayList<Human> humans;
    private ArrayList<Animal> animals;

    public String getHouseName() {
        return houseName;
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public void setHumans(ArrayList<Human> humans) {
        this.humans = humans;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseName = '" + getHouseName() + '\'' +
                ", floors = " + getFloors().size() +
                ", humans = " + getHumans().size() +
                ", animals = " + getAnimals().size() +
                '}';
    }
}
