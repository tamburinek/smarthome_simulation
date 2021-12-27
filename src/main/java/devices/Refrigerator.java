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
        ResourceEnum.ELECTRICITY.consume(2);
        if (usingDevice){
            ResourceEnum.FOOD.consume(50);
            ResourceEnum.WATER.consume(50);
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
}
