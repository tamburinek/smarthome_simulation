package devices;

import enums.DeviceType;
import house.Room;
import location.Tracker;
import manuals.Manual;
import npc.Human;
import state.DeviceState;
import state.IdleState;
import utills.Helper;

public abstract class Device extends Tracker {

    private final String deviceName;
    private final int repairDifficulty;
    private final int brokenIndex;
    private final int effectivity;
    private final DeviceType type;

    private int[] resourcesConsumed = new int[3];

    private Human humanUsingDevice = null;
    private int duration;

    private DeviceState state = new IdleState();

    private final Manual manual;

    public Device(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, DeviceType type, Manual manual) {
        this.deviceName = deviceName;
        this.repairDifficulty = repairDifficulty;
        this.brokenIndex = brokenIndex;
        this.effectivity = effectivity;
        this.type = type;
        this.manual = manual;
        setDuration();
    }

    public Manual getManual() {
        return manual;
    }

    public Human getHumanUsingDevice() {
        return humanUsingDevice;
    }

    public void setHumanUsingDevice(Human humanUsingDevice) {
        this.humanUsingDevice = humanUsingDevice;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public int getRepairDifficulty() {
        return repairDifficulty;
    }

    public int getBrokenIndex() {
        return brokenIndex;
    }

    public void setState(DeviceState state){
        this.state = state;
    }

    public DeviceState getState() {
        return state;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration() {
        this.duration = 100 - effectivity;
    }

    public int getEffectivity() {
        return effectivity;
    }

    public DeviceType getType() {
        return type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public abstract void consume(boolean usingDevice);
    public abstract int cleaning();
    public abstract int happiness();
    public abstract int fresh();
    public abstract int hungry();

    public boolean tryBreak(boolean someoneUsing){
        return Helper.breakDevice(this, someoneUsing);
    }

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

    public void buyNewDevice(Human human) {
        state.buyNewDevice(this, human);
    }

    public void callRepairman(Human human) {
        state.callRepairman(this, human);
    }

    public void tick(Human human){state.doNothingNew(this, human);}

    public int[] getResourcesConsumed() {
        return resourcesConsumed;
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
