package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import manuals.Manual;

public class Sink extends Device{
    public Sink(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.CLEANING, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        if (usingDevice){
            ResourceEnum.WATER.consume(50);
        }
    }

    @Override
    public int cleaning() {
        return 75;
    }

    @Override
    public int happiness() {
        return 2;
    }

    @Override
    public int fresh() {
        return 0;
    }
}
