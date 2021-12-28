package state;

import devices.Device;
import npc.Human;

public class BrokenState implements DeviceState{

    @Override
    public void useDevice(Device device, Human human) {
        //do nothing
    }

    @Override
    public void turnOffDevice(Device device) {
        //do nothing
    }

    @Override
    public void turnOnDevice(Device device) {
        //do nothing
    }

    @Override
    public void repairDevice(Device device, Human human) {
        device.setState(new IdleState());
        human.setDoingSt(false);
        device.setHumanUsingDevice(null);
    }

    @Override
    public void stopUsingDevice(Device device, Human human) {
        //do nothing
    }

    @Override
    public void doNothingNew(Device device, Human human) {
        //do nothing
    }

    @Override
    public void buyNewDevice(Device device, Human human) {
        device.setState(new OffState());
        human.setDoingSt(false);
        device.setHumanUsingDevice(null);

    }

    @Override
    public void callRepairman(Device device, Human human) {
        device.setState(new IdleState());
        human.setDoingSt(false);
        device.setHumanUsingDevice(null);
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public boolean isBroken() {
        return true;
    }

    @Override
    public boolean isOn() {
        return false;
    }
}
