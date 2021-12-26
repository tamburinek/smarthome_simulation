package state;

import devices.Device;
import npc.Human;

public class InUseState implements DeviceState{
    @Override
    public void useDevice(Device device, Human human) {
        //do nothing
    }

    @Override
    public void turnOffDevice(Device device) {
        device.setState(new OffState());
    }

    @Override
    public void turnOnDevice(Device device) {
        //do nothing
    }

    @Override
    public void repairDevice(Device device, Human human) {
        //do nothing
    }

    @Override
    public void stopUsingDevice(Device device, Human human) {
        device.setState(new IdleState());
    }

    @Override
    public void doNothingNew(Device device, Human human) {
        device.consume(true);
        if (device.tryBreak(true)){
            device.setState(new BrokenState());
        };
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public boolean isBroken() {
        return false;
    }

    @Override
    public boolean isOn() {
        return true;
    }
}
