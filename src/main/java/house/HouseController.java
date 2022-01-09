package house;

import devices.Device;
import enums.DeviceType;
import event.*;
import iterator.ConsumeIterator;
import iterator.EventIterator;
import iterator.NotificationIterator;
import notification.NeedsNotification;
import npc.Animal;
import npc.Baby;
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
        Time.setCurrentTime(2000,12,11);

        for (int i = 0; i < rounds; i++) {
            Time.addTime(10);

            Event.notifications.removeIf(event -> event.accept(visitor));

            Event.currentActivities.removeIf(event -> event.accept(visitor));

            Event.activitiesToDo.removeIf(event -> event.accept(visitor));

            Device device = null;

            //humans
            for (Human human : house.getHumans()) {

                if (human.isDoingSt() || !human.isAlive()){
                    continue;
                }

                if (Helper.makeSound()){
                    Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + human.getSound()));
                }

                human.dropStats();

                if (human instanceof Baby){
                    if (human.getHappiness() < 70 || human.getFresh()<70 || human.getClean()<70 || human.getHungry()<70){
                        device = Helper.findDevice(house.getDevices(), DeviceType.BABY);
                        Human human2 = Helper.findPersonForActivity(15, house.getHumans());
                        if (human2 != null && device!=null){
                            Event.activitiesToDo.add(0,new BabyEvent(device, human2, device.getDuration(), (Baby) human));
                        }
                        Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + human.getName() + " wants someone to help"));
                    }
                    continue;
                }

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
                else if (human.getHungry() < 60) {
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

            //animals
            for (Animal animal : house.getAnimals() ) {

                if (animal.isDoingSt() || !animal.isAlive()){
                    continue;
                }
                if (Helper.makeSound()){
                    Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + animal.getSound()));
                }
                animal.dropSomeStats();

                if (animal.getHappiness() < 60){
                    Human human = Helper.findPersonForActivity(16, house.getHumans());
                    Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + animal.getName() + " is sad"));
                    if (human != null){
                        Event.activitiesToDo.add(new AnimalEvent(null, human, animal, 20));
                    }
                }
                else if (animal.getHungry() < 80){
                    device = Helper.findDevice(house.getDevices(), DeviceType.ANIMAL);
                    Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + animal.getName() + " is hungry"));
                    if (device != null){
                        Event.activitiesToDo.add(new AnimalEvent(device, null, animal, device.getDuration()));
                    }
                }
            }

            for (Sensor sensor : house.getSensors()) {
                if (sensor.isSomethingWrong()){
                    sensor.makeNotification();
                }
            }

            //checking if there are some broken devices
            for (Device deviceHelper : house.getDevices()) {
                if (deviceHelper.getState().isBroken()) {
                    Human human = Helper.findPersonForActivity(16, house.getHumans());
                    if (human != null){
                        Event event = new RepairEvent(deviceHelper, human, 0);
                        Event.activitiesToDo.add(0,event);
                    }
                }
                deviceHelper.tick(deviceHelper.getHumanUsingDevice());
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

        for (Animal animal : house.getAnimals()){
            iterator.lastAnimal(animal);
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
