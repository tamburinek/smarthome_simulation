package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import location.Work;

public class WorkingComputer extends Device{

    public WorkingComputer(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.WORK);
        setLocation(Work.getInstance());
    }

    @Override
    public void consume(boolean usingDevice) {
        ResourceEnum.MONEY.add(1000);
    }

    @Override
    public int cleaning() {
        return -35;
    }

    @Override
    public int happiness() {
        return -35;
    }

    @Override
    public int fresh() {
        return -25;
    }
}
