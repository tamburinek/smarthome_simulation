package devices;

import enums.DeviceType;
import enums.ResourceEnum;
import manuals.Manual;

public class Light extends Device {
    public Light(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, DeviceType.LIGHT, manual);
    }

    @Override
    public void consume(boolean usingDevice) {
        if (usingDevice){
            getResourcesConsumed()[0] += ResourceEnum.ELECTRICITY.consume(4);
        }
        else {
            getResourcesConsumed()[0] += ResourceEnum.ELECTRICITY.consume(2);
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

    @Override
    public int hungry() {
        return 0;
    }
}
