package npc;

import devices.Device;
import enums.Constants;
import house.House;
import location.Tracker;

public abstract class Animal extends Tracker {

    private String name;
    private String sound;
    private House house;

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    private int hungry = Constants.START_HUNGRY;
    private int happiness = Constants.START_HAPPINESS;

    /**
     * getting stats from Device
     */
    public void claimSatisfy(Device device){
        hungry = Math.min(hungry + device.hungry(), Constants.MAX_HUNGRY);
    }

    /**
     * getting stats from Human - Human is here for overload
     */
    public void claimSatisfy(Human human){
        happiness = Constants.MAX_HAPPINESS;
    }

    private boolean isAlive = true;

    /**
     * every tick animal loses stats
     */
    public void dropSomeStats(){
        hungry = hungry - Constants.INDEX;
        happiness = happiness - Constants.INDEX;
        checkForDead();
    }

    /**
     * check if animal is not dead
     */
    private void checkForDead(){
        if (happiness <= 0 || hungry <= 0){
            isAlive = false;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    private boolean isDoingSt = false;

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

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
