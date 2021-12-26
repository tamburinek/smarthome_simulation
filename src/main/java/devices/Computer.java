package devices;

import enums.DeviceType;
import enums.ResourceEnum;

public class Computer extends Device{

    public Computer(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
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
        return -2;
    }

    @Override
    public int happiness() {
        return 50;
    }

    @Override
    public int fresh() {
        return -20;
    }
}
