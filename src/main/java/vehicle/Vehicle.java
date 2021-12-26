package vehicle;

import devices.Device;
import npc.Human;

public abstract class Vehicle extends Device {

    public Vehicle(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }
}
