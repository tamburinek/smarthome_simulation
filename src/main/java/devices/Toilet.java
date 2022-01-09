package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import manuals.Manual;

public class Toilet extends Device{
    public Toilet(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.JOY, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        if (usingDevice){
            getResourcesConsumed()[2] += ResourceEnum.WATER.consume(50);
        }
    }

    @Override
    public int cleaning() {
        return -10;
    }

    @Override
    public int happiness() {
        return 20;
    }

    @Override
    public int fresh() {
        return 0;
    }

    @Override
    public int hungry() {
        return -5;
    }
}
