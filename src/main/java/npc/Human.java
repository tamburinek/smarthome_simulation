package npc;

import devices.Device;
import enums.Constants;
import enums.Gender;
import event.Event;
import house.House;
import location.Tracker;
import notification.NeedsNotification;
import utills.Time;

public abstract class Human extends Tracker {

    private final String name;
    private int age;
    private final Gender gender;
    private String sound;

    private House house;
    private boolean isDoingSt = false;

    /**
     * human stats
     */
    private int happiness = Constants.START_HAPPINESS;
    private int hungry = Constants.START_HUNGRY;
    private int clean = Constants.START_CLEAN;
    private int fresh = Constants.START_FRESH;

    private boolean isAlive = true;


    public Human(String name, int age, Gender gender,String sound){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sound = sound;
    }

    /**
     * claim stats from device
     */
    public void claimSatisfy(Device device){
        happiness = Math.min(happiness + device.happiness(), Constants.MAX_HAPPINESS);
        clean = Math.min(clean + device.cleaning(), Constants.MAX_CLEAN);
        fresh = Math.min(fresh + device.fresh(), Constants.MAX_FRESH);
        hungry = Math.min(hungry + device.hungry(), Constants.MAX_HUNGRY);
    }

    /**
     * every tick human loses his stats
     */
    public void dropStats(){
        happiness = happiness - Constants.INDEX;
        fresh = fresh - Constants.INDEX;
        clean = clean - Constants.INDEX;
        hungry = hungry - Constants.INDEX;
        checkForDead();
    }

    private void checkForDead(){
        if (fresh <= 0 || happiness <= 0 || hungry <= 0 || clean <= 0){
            Event.allNotifications.add(new NeedsNotification(Time.getCurrentTime() + " - " + getName() + " died"));
            isAlive = false;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int health) {
        this.hungry = health;
    }

    public int getClean() {
        return clean;
    }

    public void setClean(int clean) {
        this.clean = clean;
    }

    public int getFresh() {
        return fresh;
    }

    public void setFresh(int fresh) {
        this.fresh = fresh;
    }

    public boolean isDoingSt() {
        return isDoingSt;
    }

    public void setDoingSt(boolean doingSt) {
        isDoingSt = doingSt;
    }

    public Gender getGender() {
        return gender;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void printStats(){
        System.out.println("Hungry: " + hungry + ", Clean: " + clean + ", Fresh: " + fresh + ", Happiness: " + happiness);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
