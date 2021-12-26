package devices;

import enums.DeviceType;

public class Window extends Device {
    public Window(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.WINDOW);
    }

    @Override
    public void consume(boolean usingDevice) {

    }

    @Override
    public int cleaning() {
        return 0;
    }

    @Override
    public int happiness() {
        return 0;
    }

    @Override
    public int fresh() {
        return 0;
    }
}
