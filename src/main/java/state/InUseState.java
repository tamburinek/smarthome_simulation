package state;

import devices.Device;
import npc.Human;

public class InUseState implements DeviceState{
    @Override
    public void useDevice(Device device, Human human) {

    }

    @Override
    public void turnOffDevice(Device device) {

    }

    @Override
    public void turnOnDevice(Device device) {

    }

    @Override
    public void repairDevice(Device device, Human human) {

    }

    @Override
    public void stopUsingDevice(Device device, Human human) {

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
