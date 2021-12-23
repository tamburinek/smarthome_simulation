package state;

import devices.Device;

public class IdleState implements DeviceState{

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

    public String toString(){
        return "IdleState";
    }
}
