package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import location.Work;
import manuals.Manual;

public class WorkingComputer extends Device{

    public WorkingComputer(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.WORK, manual);
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

    @Override
    public int hungry() {
        return -30;
    }
}
