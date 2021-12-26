package sensors;

import devices.Device;

public class LightSensor extends Sensor{

    public LightSensor(Device sensorDevice) {
        super(sensorDevice);
    }

    @Override
    public boolean isSomethingWrong() {
        return false;
    }

    @Override
    public void makeNotification() {

    }

    //todo implement when it is evening to turn the lights on
}
