package devices;

import location.Tracker;
import state.DeviceState;
import state.IdleState;

public abstract class Device extends Tracker {

    private final String deviceName;
    private int repairDifficulty;
    private int brokenIndex;
    private boolean isOccupied = false;
    private DeviceState state = new IdleState();

    public Device(String deviceName, int repairDifficulty, int brokenIndex) {
        this.deviceName = deviceName;
        this.repairDifficulty = repairDifficulty;
        this.brokenIndex = brokenIndex;
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

    public void setOccupied(boolean occupied){
        isOccupied = occupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }


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

}
