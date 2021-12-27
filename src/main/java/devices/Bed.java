package devices;

import enums.DeviceType;
import manuals.Manual;

public class Bed extends Device{

    public Bed(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.SLEEPING, manual);
    }


    @Override
    public void consume(boolean usingDevice) {
        //consume nothing
    }

    @Override
    public int cleaning() {
        return -10;
    }

    @Override
    public int happiness() {
        return 100;
    }

    @Override
    public int fresh() {
        return 100;
    }
}
