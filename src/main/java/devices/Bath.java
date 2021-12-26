package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import resource.Resource;

public class Bath extends Device{

    public Bath(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.CLEANING);
    }

    @Override
    public void consume(boolean usingDevice) {
        if (usingDevice){
            ResourceEnum.WATER.consume(50);
            ResourceEnum.ELECTRICITY.consume(40);
        }
        else {
            ResourceEnum.ELECTRICITY.consume(2);
        }
    }

    @Override
    public int cleaning() {
        return 100;
    }

    @Override
    public int happiness() {
        return 40;
    }

    @Override
    public int fresh() {
        return 10;
    }
}
