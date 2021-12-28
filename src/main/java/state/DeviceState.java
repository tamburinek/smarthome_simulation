package state;

import devices.Device;
import npc.Human;

public interface DeviceState {

    void useDevice(Device device, Human human);
    void turnOffDevice(Device device);
    void turnOnDevice(Device device);
    void repairDevice(Device device, Human human);
    void stopUsingDevice(Device device, Human human);
    void doNothingNew(Device device, Human human);
    void buyNewDevice(Device device, Human human);
    void callRepairman(Device device, Human human);

    boolean isOccupied();
    boolean isBroken();
    boolean isOn();
}
