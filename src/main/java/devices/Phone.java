package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import manuals.Manual;

public class Phone extends Device{
    public Phone(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.JOY, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        ResourceEnum.ELECTRICITY.consume(5);
    }

    @Override
    public int cleaning() {
        return 0;
    }

    @Override
    public int happiness() {
        return 20;
    }

    @Override
    public int fresh() {
        return 10;
    }

    @Override
    public int hungry() {
        return 0;
    }
}
