package state;

import devices.Device;

public class InUseState implements DeviceState{
    @Override
    public void useDevice(Device device) {

    }

    @Override
    public void turnOffDevice(Device device) {

    }

    @Override
    public void turnOnDevice(Device device) {

    }

    @Override
    public void repairDevice(Device device) {

    }

    @Override
    public void stopUsingDevice(Device device) {

    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public boolean isBroken() {
        return false;
    }
}
