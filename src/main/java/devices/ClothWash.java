package devices;

import enums.DeviceType;
import enums.Gender;
import enums.ResourceEnum;

public class ClothWash extends Device{

    public ClothWash(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
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
        return 40;
    }

    @Override
    public int happiness() {
        if (getHumanUsingDevice().getGender() == Gender.FEMALE){
            return 20;
        } else{
            return -10;
        }
    }

    @Override
    public int fresh() {
        return -10;
    }
}
