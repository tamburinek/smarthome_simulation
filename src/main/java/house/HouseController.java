package house;

import devices.Device;
import enums.DeviceType;
import event.*;
import iterator.ConsumeIterator;
import iterator.EventIterator;
import iterator.NotificationIterator;
import notification.NeedsNotification;
import npc.Animal;
import npc.Human;
import sensors.Sensor;
import strategy.DifficultyStrategy;
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

                if (human.isDoingSt() || !human.isAlive()){
                    continue;
                }

                human.dropStats();

                if (human.getClean() < 60){
                    device = Helper.findDevice(house.getDevices(), DeviceType.CLEANING);
                    Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + human.getName() + " is dirty"));
                }
                else if (human.getHappiness() < 60){
                    device = Helper.findDevice(house.getDevices(), DeviceType.JOY);
                    Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + human.getName() + " is sad"));
                }
                else if (human.getFresh() < 60) {
                    device = Helper.findDevice(house.getDevices(), DeviceType.SLEEPING);
                    Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + human.getName() + " is tired"));
                }
                else if (human.getHungry() < 20) {
                    device = Helper.findDevice(house.getDevices(), DeviceType.EAT);
                    Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + human.getName() + " is hungry"));
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

        //iterating final results

        String filename = "reports/" + difficulty.toString() + "/ActivityAndUsageReport.txt";
        String filename1 = "reports/" + difficulty.toString() + "/EventReport.txt";
        String filename2 = "reports/" + difficulty.toString() + "/ConsumptionReport.txt";

        EventIterator iterator = new EventIterator(filename);
        NotificationIterator iterator1  = new NotificationIterator(filename1);
        ConsumeIterator iterator2 = new ConsumeIterator(filename2, house.getDevices());

        while (iterator.hasNext()){
            iterator.next();
        }
        for (Human human : house.getHumans()){
            iterator.last(human);
        }

        while (iterator1.hasNext()){
            iterator1.next();
        }

        while (iterator2.hasNext()){
            iterator2.next();
        }
        iterator2.last();
    }
}
