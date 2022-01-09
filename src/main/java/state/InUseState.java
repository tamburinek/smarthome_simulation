package state;

import devices.Device;
import enums.NotificationType;
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
        device.getObservers().update(NotificationType.ENDED_USING);
        human.setDoingSt(false);
        device.setHumanUsingDevice(null);
        device.setState(new IdleState());
        /*if (device.tryBreak(true)){
            human.setDoingSt(false);
            device.setHumanUsingDevice(null);
            device.setState(new BrokenState());
        }*/
    }

    @Override
    public void doNothingNew(Device device, Human human) {
        device.consume(true);
    }

    @Override
    public void buyNewDevice(Device device, Human human) {
        //do nothing
    }

    @Override
    public void callRepairman(Device device, Human human) {
        //do nothing
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
