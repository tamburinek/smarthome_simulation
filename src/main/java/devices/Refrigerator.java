package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import manuals.Manual;

public class Refrigerator extends Device {
    public Refrigerator(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.EAT, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        getResourcesConsumed()[0] += ResourceEnum.ELECTRICITY.consume(5);
        if (usingDevice){
            ResourceEnum.FOOD.consume(50);
            getResourcesConsumed()[2] += ResourceEnum.WATER.consume(50);
        }
    }

    @Override
    public int cleaning() {
        return -5;
    }

    @Override
    public int happiness() {
        return 55;
    }

    @Override
    public int fresh() {
        return -10;
    }

    @Override
    public int hungry() {
        return 100;
    }
}
