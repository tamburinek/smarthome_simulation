package house;

import devices.Device;
import npc.Animal;
import npc.Human;
import sensors.Sensor;
import strategy.DifficultyStrategy;
import strategy.EasyStrategy;
import utills.Time;

import java.util.ArrayList;

public class HouseController {

    private final House house;
    private DifficultyStrategy difficulty;

    public HouseController(House house) {
        this.house = house;
        this.difficulty = new EasyStrategy();
    }

    public Device findDeviceForClean(){
        //todo
        return null;
    }

    public Device findDeviceForJoy(){
        //todo
        return null;
    }

    public Human findPersonForRepair(int required){
        //todo
        return null;
    }

    public void runSimulation(int rounds){
        difficulty.setParams();

        for (int i = 0; i < rounds; i++) {
            Time.addTime(10);
            System.out.println(Time.getCurrentTime());

            for (Human human : house.getHumans()) {
                //todo human.doSomething
                System.out.println(human);
            }

            for (Animal animal : house.getAnimals() ) {
                //todo animal.doSomething
                System.out.println(animal);
            }

            for (Device device : house.getDevices()) {
                //todo device.doSomething
                System.out.println(device);
            }

            for (Sensor sensor : house.getSensors()) {
                //todo sensor.doSomething
                System.out.println(sensor);
            }
        }
    }

    public DifficultyStrategy getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyStrategy difficulty) {
        this.difficulty = difficulty;
    }
}
