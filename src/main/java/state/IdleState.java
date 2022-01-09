package state;

import devices.Device;
import enums.NotificationType;
import npc.Human;

public class IdleState implements DeviceState{

    @Override
    public void useDevice(Device device, Human human) {
        device.setHumanUsingDevice(human);
        human.setDoingSt(true);
        device.getObservers().update(NotificationType.STARTED_USING);
        device.setState(new InUseState());
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
            device.getObservers().update(NotificationType.BROKE_IN_IDLE);
            device.setState(new BrokenState());
        }
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
