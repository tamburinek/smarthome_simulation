package sensors;

import devices.Device;
import house.House;

public interface Sensor {

    public abstract boolean isSomethingWrong();
    public abstract void makeNotification();
    public abstract String getName();
}
