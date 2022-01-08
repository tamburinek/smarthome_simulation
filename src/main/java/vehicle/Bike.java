package vehicle;

import enums.DeviceType;
import manuals.Manual;

public class Bike extends Vehicle{

    public Bike(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.SPORT, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        //consume nothing
    }

    @Override
    public int cleaning() {
        return -30;
    }

    @Override
    public int happiness() {
        return 30;
    }

    @Override
    public int fresh() {
        return -20;
    }

    @Override
    public int hungry() {
        return -10;
    }
}
