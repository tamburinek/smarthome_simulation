package house;

import devices.Device;
import npc.Animal;
import npc.Human;
import observer.DeviceObserver;
import observer.Observer;
import sensors.Sensor;

import java.util.ArrayList;

public class House {

    private String houseName;
    private ArrayList<Floor> floors = new ArrayList<>();
    private ArrayList<Human> humans = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Sensor> sensors = new ArrayList<>();
    private ArrayList<Device> devices = new ArrayList<>();

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

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
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

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void setDevices() {
        for (Floor floor : getFloors()) {
            for (Room room : floor.getRooms()) {
                devices.addAll(room.getDevices());
            }
        }
    }

    public void setLocation(){
        for (Floor floor : floors) {
            floor.setHouse(this);
        }

        for (Human human : humans) {
            human.setHouse(this);
        }

        for (Animal animal : animals){
            animal.setHouse(this);
        }

        for (Sensor sensor : sensors){
            sensor.setHouse(this);
        }

    }

    public void atachObserver() {
        for (Device device : devices) {
            new DeviceObserver(device);
        }
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
