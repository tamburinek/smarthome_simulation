package devices;

import location.Tracker;
import state.DeviceState;
import state.IdleState;

public abstract class Device extends Tracker {

    private boolean isOccupied = false;

    private DeviceState state = new IdleState();

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

    public void useDevice() {
        state.useDevice(this);
    }

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
