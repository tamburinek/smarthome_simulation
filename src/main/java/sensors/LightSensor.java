package sensors;

import devices.Device;

public class LightSensor implements Sensor{

    @Override
    public boolean isSomethingWrong() {
        return false;
    }

    @Override
    public void makeNotification() {

    }
}
