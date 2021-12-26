package npc;

import devices.Device;
import enums.Constants;
import enums.Gender;
import house.House;
import location.Tracker;

public abstract class Human extends Tracker {

    private final String name;
    private int age;
    private final Gender gender;

    private House house;
    private boolean isDoingSt = false;

    private int happiness = Constants.START_HAPPINESS;
    private int hungry = Constants.START_HUNGRY;
    private int clean = Constants.START_CLEAN;
    private int fresh = Constants.START_FRESH;


    public Human(String name, int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void claimSatisfy(Device device){
        happiness = happiness += device.happiness();
        clean = clean += device.cleaning();
        fresh = fresh += device.fresh();
    }

    public void doNothing(){
        happiness = happiness - 1;
        fresh = fresh - 1;
        clean = clean - 1;
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

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
