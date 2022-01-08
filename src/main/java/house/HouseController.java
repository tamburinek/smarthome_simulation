package house;

import devices.Device;
import enums.Activity;
import event.BasicEvent;
import event.Event;
import event.EventVisitor;
import event.RepairEvent;
import npc.Animal;
import npc.Human;
import sensors.Sensor;
import strategy.DifficultyStrategy;
import strategy.EasyStrategy;
import utills.Helper;
import utills.Time;

import java.util.Iterator;

public class HouseController {

    private final House house;
    private DifficultyStrategy difficulty;

    public HouseController(House house) {
        this.house = house;
        this.difficulty = new EasyStrategy();
    }

    public void runSimulation(int rounds){
        difficulty.setParams();
        EventVisitor visitor = new EventVisitor();

        Time.setCurrentTime(2012,10,23);

        for (int i = 0; i < rounds; i++) {
            Time.addTime(10);
            System.out.println("----------------------");
            System.out.println(Time.getCurrentTime());

            Iterator<Event> itr = Event.currentActivities.iterator();
            while (itr.hasNext()) {
                Event event = itr.next();
                if (event.accept(visitor)) {
                    itr.remove();
                }
            }

            Iterator<Event> itr2 = Event.activitiesToDo.iterator();
            while (itr2.hasNext()) {
                Event event = itr2.next();
                if (event.accept(visitor)) {
                    itr2.remove();
                }
            }

            for (Human human : house.getHumans()) {
                if (human.isDoingSt()){
                    continue;
                }
                human.doNothing();
                if (human.getClean() < 40){
                    Device device = Helper.findDeviceForClean(house.getDevices());
                    if (device != null){
                        Event.activitiesToDo.add(new BasicEvent(device, human, device.getDuration(), Activity.USING));
                        human.setDoingSt(true);
                    }
                    continue;
                }
                else if (human.getHappiness() < 40){
                    Device device = Helper.findDeviceForJoy(house.getDevices());
                    if (device != null){
                        Event.activitiesToDo.add(new BasicEvent(device, human, device.getDuration(), Activity.USING));
                        human.setDoingSt(true);
                    }
                    continue;
                }
                else if (human.getFresh() < 40) {
                    Device device = Helper.findDeviceForSleep(house.getDevices());
                    if (device != null){
                        Event.activitiesToDo.add(new BasicEvent(device, human, device.getDuration(), Activity.USING));
                        human.setDoingSt(true);
                    }
                    continue;
                }
                else if (human.getHungry() < 40) {
                    Device device = Helper.findDeviceToEat(house.getDevices());
                    if (device != null){
                        Event.activitiesToDo.add(new BasicEvent(device, human, device.getDuration(), Activity.USING));
                        human.setDoingSt(true);
                    }
                }
                else {
                    Device device = Helper.findRandomDevice(house.getDevices());
                    if (device != null){
                        Event.activitiesToDo.add(new BasicEvent(device, human, device.getDuration(), Activity.USING));
                        human.setDoingSt(true);
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
                    Event.activitiesToDo.add(event);
                }
                device.getState().doNothingNew(device, device.getHumanUsingDevice());
                //System.out.println("device: " + device.getDeviceName() + " state: " + device.getState() + " broken: " + device.getBrokenIndex());
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
