package house;

import devices.Device;
import enums.Activity;
import event.BasicEvent;
import event.Event;
import event.RepairEvent;
import npc.Animal;
import npc.Human;
import sensors.Sensor;
import strategy.DifficultyStrategy;
import strategy.EasyStrategy;
import utills.Helper;
import utills.Time;

public class HouseController {

    private final House house;
    private DifficultyStrategy difficulty;

    public HouseController(House house) {
        this.house = house;
        this.difficulty = new EasyStrategy();
    }

    public void runSimulation(int rounds){
        difficulty.setParams();

        for (int i = 0; i < rounds; i++) {
            Time.addTime(10);
            System.out.println(Time.getCurrentTime());

            //todo zkontrolovat eventy - az bude hotovy visitor

            for (Human human : house.getHumans()) {
                if (human.isDoingSt()){
                    continue;
                }
                if (human.getClean() < 40){
                    Device device = Helper.findDeviceForClean(house.getDevices());
                    if (device != null){
                        Event event = new BasicEvent(device, human, device.getDuration(), Activity.USING);
                        human.setDoingSt(true);
                        Event.eventsToDo.add(event);
                    }
                    continue;
                }
                if (human.getHappiness() < 20){
                    Device device = Helper.findDeviceForJoy(house.getDevices());
                    if (device != null){
                        Event event = new BasicEvent(device, human, device.getDuration(), Activity.USING);
                        human.setDoingSt(true);
                        Event.eventsToDo.add(event);
                    }
                    continue;
                }
                if (human.getFresh() < 40) {
                    Device device = Helper.findDeviceForSleep(house.getDevices());
                    if (device != null){
                        Event event = new BasicEvent(device, human, device.getDuration(), Activity.USING);
                        human.setDoingSt(true);
                        Event.eventsToDo.add(event);
                    }
                    continue;
                }
                if (human.getHungry() < 20) {
                    Device device = Helper.findDeviceToEat(house.getDevices());
                    if (device != null){
                        Event event = new BasicEvent(device, human, device.getDuration(), Activity.USING);
                        human.setDoingSt(true);
                        Event.eventsToDo.add(event);
                    }
                }
            }

            for (Animal animal : house.getAnimals() ) {
                //todo animal.doSomething
            }

            for (Sensor sensor : house.getSensors()) {
                if (sensor.isSomethingWrong()){
                    sensor.makeNotification();
                }
            }

            for (Device device : house.getDevices()) {
                if (device.getState().isBroken()) {
                    Human human = Helper.findPersonForRepair(16, house.getHumans());
                    Event event = new RepairEvent(device, human, device.getDuration(), Activity.REPAIRING);
                    Event.eventsToDo.add(event);
                }
                device.getState().doNothingNew(device, device.getHumanUsingDevice());
                //System.out.println("device: " + device.getDeviceName() + " state: " + device.getState() + " broken: " + device.getBrokenIndex());
            }

            for (Human human : house.getHumans()) {
                if (human.isDoingSt()){
                    continue;
                }
                Device device = Helper.findRandomDevice(house.getDevices());
                if (device != null){
                    Event event = new BasicEvent(device, human, device.getDuration(), Activity.USING);
                    human.setDoingSt(true);
                    Event.eventsToDo.add(event);
                }
                //System.out.println("jmeno: " + human.getName() + " happiness: " + human.getHappiness() + " clean: " + human.getClean() + " hungry: " + human.getHungry());
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
