package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import manuals.Manual;

public class AnimalRefrigerator extends Device{

    public AnimalRefrigerator(String deviceName, int repairDifficulty, int brokenIndex, int effectivity,Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.ANIMAL, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        getResourcesConsumed()[0] += ResourceEnum.ELECTRICITY.consume(5);
        if (usingDevice){
            ResourceEnum.FOOD.consume(10);
            getResourcesConsumed()[2] += ResourceEnum.WATER.consume(10);
        }
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
        return 0;
    }

    @Override
    public int hungry() {
        return 100;
    }
}
