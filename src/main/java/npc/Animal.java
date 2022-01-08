package npc;

import devices.Device;
import enums.Constants;
import house.House;
import location.Tracker;

public abstract class Animal extends Tracker {

    private String name;
    private House house;

    private int hungry = Constants.START_HUNGRY;
    private int happiness = Constants.START_HAPPINESS;

    public void claimSatisfy(Device device){
        hungry = Math.min(hungry + device.hungry(), Constants.MAX_HUNGRY);
    }

    public abstract void playWithHuman(Human human);

    private boolean isAlive = true;

    public void doNothing(){
        hungry = hungry - Constants.INDEX;
        happiness = happiness - Constants.INDEX;
        checkForDead();
    }

    private void checkForDead(){
        if (happiness <= 0 || hungry <= 0){
            isAlive = false;
        }
    }

    private boolean isDoingSt = false;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public boolean isDoingSt() {
        return isDoingSt;
    }

    public void setDoingSt(boolean doingSt) {
        isDoingSt = doingSt;
    }

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
