package devices;

import enums.DeviceType;
import manuals.Manual;
import manuals.ManualProxyImpl;

public class Window extends Device {

    public Window(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.WINDOW, manual);
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
