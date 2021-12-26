package state;

import devices.Device;
import npc.Human;

public interface DeviceState {

    public void useDevice(Device device, Human human);
    public void turnOffDevice(Device device);
    public void turnOnDevice(Device device);
    public void repairDevice(Device device, Human human);
    public void stopUsingDevice(Device device, Human human);

    public boolean isOccupied();
    public boolean isBroken();


}
