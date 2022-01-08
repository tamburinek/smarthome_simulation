package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import manuals.Manual;

public class Bath extends Device{

    public Bath(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.CLEANING, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        if (usingDevice){
            getResourcesConsumed()[0] += ResourceEnum.ELECTRICITY.consume(40);
            getResourcesConsumed()[2] += ResourceEnum.WATER.consume(50);
        }
        else {
            getResourcesConsumed()[0] += ResourceEnum.ELECTRICITY.consume(2);
        }
    }

    @Override
    public int cleaning() {
        return 100;
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
