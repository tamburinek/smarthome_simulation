package devices;

import enums.DeviceType;
import enums.Gender;
import enums.ResourceEnum;
import manuals.Manual;

public class DishWash extends Device{

    public DishWash(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.CLEANING, manual);
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
        return 20;
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
        if (getHumanUsingDevice().getGender() == Gender.FEMALE){
            return 20;
        } else{
            return -10;
        }
    }
}
