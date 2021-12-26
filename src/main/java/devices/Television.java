package devices;

import enums.DeviceType;
import enums.ResourceEnum;

public class Television extends Device{
    public Television(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.JOY);
    }

    @Override
    public void consume(boolean usingDevice) {
        if (usingDevice){
            ResourceEnum.ELECTRICITY.consume(40);
        }
        else {
            ResourceEnum.ELECTRICITY.consume(2);
        }
    }

    @Override
    public int cleaning() {
        return -20;
    }

    @Override
    public int happiness() {
        return 45;
    }

    @Override
    public int fresh() {
        return 20;
    }
}
