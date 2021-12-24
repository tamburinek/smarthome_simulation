package house;

import devices.Device;
import npc.Animal;
import npc.Human;
import sensors.Sensor;
import utills.Time;

import java.util.ArrayList;

public class HouseController {

    private House house;
    private ArrayList<Device> devices = new ArrayList<>();

    public HouseController(House house) {
        this.house = house;
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                devices.addAll(room.getDevices());
            }
        }
    }

    public void runSimulation(int rounds){

        for (int i = 0; i < rounds; i++) {
            Time.addTime(10);
            System.out.println(Time.getCurrentTime());

            for (Human human : house.getHumans()) {
                System.out.println(human);
            }

            for (Animal animal : house.getAnimals() ) {
                System.out.println(animal);
            }

            for (Device device : devices) {
                System.out.println(device);
            }

            for (Sensor sensor : house.getSensors()) {
                System.out.println(sensor);
            }
        }
    }
}
