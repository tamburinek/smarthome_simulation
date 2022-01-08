package house;

import devices.Device;
import enums.DeviceType;
import event.*;
import iterator.EventIterator;
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

    public HouseController(House house, DifficultyStrategy strategy) {
        this.house = house;
        this.difficulty = strategy;
    }

    public void runSimulation(int rounds){
        difficulty.setParams();
        EventVisitor visitor = new EventVisitor();
        Time.setCurrentTime(2012,10,23);

        for (int i = 0; i < rounds; i++) {
            Time.addTime(10);

            Event.notifications.removeIf(event -> event.accept(visitor));

            Event.currentActivities.removeIf(event -> event.accept(visitor));

            Event.activitiesToDo.removeIf(event -> event.accept(visitor));

            Device device = null;

            for (Human human : house.getHumans()) {

                human.doNothing();

                if (human.isDoingSt() || !human.isAlive()){
                    continue;
                }

                if (human.getClean() < 60){
                    device = Helper.findDevice(house.getDevices(), DeviceType.CLEANING);
                }
                else if (human.getHappiness() < 60){
                    device = Helper.findDevice(house.getDevices(), DeviceType.JOY);
                }
                else if (human.getFresh() < 60) {
                    device = Helper.findDevice(house.getDevices(), DeviceType.SLEEPING);
                }
                else if (human.getHungry() < 60) {
                    device = Helper.findDevice(house.getDevices(), DeviceType.EAT);
                }
                else {
                    device = Helper.findRandomDevice(house.getDevices());
                }
                if (device != null){
                    Event.activitiesToDo.add(new BasicEvent(device, human, device.getDuration()));
                    human.setDoingSt(true);
                }
            }

            for (Animal animal : house.getAnimals() ) {
                //todo
            }

            for (Sensor sensor : house.getSensors()) {
                if (sensor.isSomethingWrong()){
                    sensor.makeNotification();
                }
            }

            for (Device deviceHelper : house.getDevices()) {
                if (deviceHelper.getState().isBroken()) {
                    Human human = Helper.findPersonForRepair(16, house.getHumans());
                    Event event = new RepairEvent(device, human, deviceHelper.getDuration());
                    Event.activitiesToDo.add(event);
                }
                deviceHelper.getState().doNothingNew(deviceHelper, deviceHelper.getHumanUsingDevice());
            }
        }

        if (difficulty.toString().equals("easy")){
            EventIterator iterator = new EventIterator("ActivityAndUsageReportEasyMode.txt");
            while (iterator.hasNext()){
                iterator.next();
            }
            for (Human human : house.getHumans()){
                iterator.last(human);
            }
        }
    }
}
