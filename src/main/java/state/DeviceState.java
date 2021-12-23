package state;

import devices.Device;

public interface DeviceState {

    public void useDevice(Device device);
    public void turnOffDevice(Device device);
    public void turnOnDevice(Device device);
    public void repairDevice(Device device);
    public void stopUsingDevice(Device device);
}
