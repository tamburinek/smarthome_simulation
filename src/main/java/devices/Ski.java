package devices;

import enums.DeviceType;
import manuals.Manual;

public class Ski extends Device{

    public Ski(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.SPORT, manual);
    }

    @Override
    public void consume(boolean usingDevice) {

    }

    @Override
    public int cleaning() {
        return -20;
    }

    @Override
    public int happiness() {
        return 100;
    }

    @Override
    public int fresh() {
        return -40;
    }

    @Override
    public int hungry() {
        return -20;
    }
}
