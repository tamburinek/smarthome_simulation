package devices;

import enums.ResourceEnum;

public class Refrigerator extends Device {
    public Refrigerator(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
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
