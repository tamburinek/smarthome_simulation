package house;

import npc.Animal;
import npc.Human;
import sensors.Sensor;

import java.util.ArrayList;

/**
 * builder pattern
 */
public class HouseBuilder {

    private House house = new House();

    public HouseBuilder houseName(String name){
        house.setHouseName(name);
        return this;
    }
    public HouseBuilder floors(ArrayList<Floor> floors){
        house.setFloors(floors);
        return this;
    }

    public HouseBuilder humans(ArrayList<Human> humans) {
        house.setHumans(humans);
        return this;
    }

    public HouseBuilder animals(ArrayList<Animal> animals){
        house.setAnimals(animals);
        return this;
    }

    public HouseBuilder sensors(ArrayList<Sensor> sensors){
        house.setSensors(sensors);
        return this;
    }

    public House getResult(){
        house.setLocation();
        house.setDevices();
        house.atachObserver();
        return house;
    }
}
