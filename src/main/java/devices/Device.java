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
    private int effectivity;

    private Human humanUsingDevice = null;
    private int duration;

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = 100 - effectivity;
    }

    public abstract void consume();
    public abstract int cleaning();
    public abstract int happiness();

    //states
    public void useDevice(Human human){state.useDevice(this, human);}

    public void turnOffDevice() {
        state.turnOffDevice(this);
    }

    public void turnOnDevice() {
        state.turnOnDevice(this);
    }

    public void repairDevice(Human human) {
        state.repairDevice(this, human);
    }

    public void stopUsingDevice(Human human){
        state.stopUsingDevice(this, human);
    }


    @Override
    public String toString() {
        return "Device{" +
                "deviceName='" + deviceName + '\'' +
                ", repairDifficulty=" + repairDifficulty +
                ", brokenIndex=" + brokenIndex +
                ", occupied=" + state.isOccupied() +
                ", broken=" + state.isBroken() +
                '}';
    }
}
