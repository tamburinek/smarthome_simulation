package state;

import devices.Device;
import npc.Human;

public class IdleState implements DeviceState{

    @Override
    public void useDevice(Device device, Human human) {
        device.setState(new InUseState());
        device.setHumanUsingDevice(human);
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
        //do nothing
    }

    @Override
    public void doNothingNew(Device device, Human human) {
        device.consume(false);
        if (device.tryBreak(false)){
            device.setHumanUsingDevice(null);
            device.setState(new BrokenState());
        };
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public boolean isBroken() {
        return false;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    public String toString(){
        return "IdleState";
    }
}
