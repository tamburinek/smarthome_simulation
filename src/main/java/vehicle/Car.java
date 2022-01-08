package vehicle;

import enums.DeviceType;
import enums.Gender;
import enums.ResourceEnum;
import manuals.Manual;

public class Car extends Vehicle{

    public Car(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.TRANSPORT, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        ResourceEnum.GAS.consume(100);
    }

    @Override
    public int cleaning() {
        return -2;
    }

    @Override
    public int happiness() {
        if (getHumanUsingDevice().getGender() == Gender.FEMALE){
            return -10;
        } else{
            return 30;
        }
    }

    @Override
    public int fresh() {
        return -5;
    }

    @Override
    public int hungry() {
        return 0;
    }
}
