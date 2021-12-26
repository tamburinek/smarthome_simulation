package devices;

import enums.ResourceEnum;

public class Phone extends Device{
    public Phone(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
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
}
