package devices;

import enums.DeviceType;
import enums.ResourceEnum;

public class Light extends Device {
    public Light(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.LIGHT);
    }

    @Override
    public void consume(boolean usingDevice) {
        if (usingDevice){
            ResourceEnum.ELECTRICITY.consume(4);
        }
        else {
            ResourceEnum.ELECTRICITY.consume(2);
        }
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
