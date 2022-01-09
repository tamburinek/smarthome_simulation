package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import manuals.Manual;

public class BabyDeviceForEverything extends Device{

    public BabyDeviceForEverything(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.BABY, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        if (usingDevice){
            getResourcesConsumed()[0] += ResourceEnum.ELECTRICITY.consume(100);
            getResourcesConsumed()[1] += ResourceEnum.GAS.consume(100);
            getResourcesConsumed()[2] += ResourceEnum.WATER.consume(100);
            ResourceEnum.FOOD.consume(100);
        }
        else {
            getResourcesConsumed()[0] += ResourceEnum.ELECTRICITY.consume(2);
            getResourcesConsumed()[1] += ResourceEnum.GAS.consume(2);
            getResourcesConsumed()[2] += ResourceEnum.WATER.consume(2);
        }
    }

    @Override
    public int cleaning() {
        return 100;
    }

    @Override
    public int happiness() {
        return 100;
    }

    @Override
    public int fresh() {
        return 100;
    }

    @Override
    public int hungry() {
        return 100;
    }
}
