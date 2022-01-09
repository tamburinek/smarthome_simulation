package sensors;

import devices.Device;
import house.House;

public interface Sensor {

    public abstract boolean isSomethingWrong();
    public abstract String getName();
}
