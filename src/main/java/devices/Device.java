package devices;

import house.Room;
import location.Tracker;
import npc.Human;
import state.DeviceState;
import state.IdleState;

public abstract class Device extends Tracker {

    private final String deviceName;
    private int repairDifficulty;
    private int brokenIndex;
    private int lives = 100;
    private int effectivity;

    private Human humanUsingDevice;

    //todo
    private int duration = 0;

    private Room room;

    private DeviceState state = new IdleState();

    public Device(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        this.deviceName = deviceName;
        this.repairDifficulty = repairDifficulty;
        this.brokenIndex = brokenIndex;
        this.effectivity = effectivity;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives){
        this.lives = lives;
    }

    public int getRepairDifficulty() {
        return repairDifficulty;
    }

    public void setRepairDifficulty(int repairDifficulty) {
        this.repairDifficulty = repairDifficulty;
    }

    public int getBrokenIndex() {
        return brokenIndex;
    }

    public void setBrokenIndex(int brokenIndex) {
        this.brokenIndex = brokenIndex;
    }

    public void setState(DeviceState state){
        this.state = state;
    }

    public DeviceState getState() {
        return state;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    //todo implement consume for each device
    protected abstract void consume();

    //states
    public void useDevice(){state.useDevice(this);}

    public void turnOffDevice() {
        state.turnOffDevice(this);
    }

    public void turnOnDevice() {
        state.turnOnDevice(this);
    }

    public void repairDevice() {
        state.repairDevice(this);
    }

    public void stopUsingDevice(){
        state.stopUsingDevice(this);
    }


    @Override
    public String toString() {
        return "Device{" +
                "deviceName='" + deviceName + '\'' +
                ", repairDifficulty=" + repairDifficulty +
                ", brokenIndex=" + brokenIndex +
                ", lives=" + lives +
                ", occupied=" + state.isOccupied() +
                ", broken=" + state.isBroken() +
                '}';
    }
}
