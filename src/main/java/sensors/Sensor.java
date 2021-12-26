package sensors;

import devices.Device;
import house.House;

public abstract class Sensor {

    private House house;
    private final Device sensorDevice;

    public Sensor(Device sensorDevice) {
        this.sensorDevice = sensorDevice;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Device getSensorDevice() {
        return sensorDevice;
    }

    //todo
    public abstract boolean isSomethingWrong();
    public abstract void makeNotification();
}
