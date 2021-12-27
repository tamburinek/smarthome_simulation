package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import manuals.Manual;

public class Radio extends Device{
    public Radio(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.SLEEPING, manual);
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
        return 0;
    }

    @Override
    public int happiness() {
        return 15;
    }

    @Override
    public int fresh() {
        return 20;
    }
}
