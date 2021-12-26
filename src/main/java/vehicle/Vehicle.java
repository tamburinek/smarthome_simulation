package vehicle;

import devices.Device;
import enums.DeviceType;
import npc.Human;

public abstract class Vehicle extends Device {

    public Vehicle(String deviceName, int repairDifficulty, int brokenIndex, int effectivity, DeviceType type) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity, type);
    }

}
