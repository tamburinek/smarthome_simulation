package vehicle;

import devices.Device;
import enums.DeviceType;
import manuals.Manual;
import npc.Human;

public abstract class Vehicle extends Device {

    public Vehicle(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, DeviceType type , Manual manual) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, type, manual);
    }

    @Override
    public int hungry() {
        return 0;
    }

}
