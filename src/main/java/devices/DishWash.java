package devices;

import npc.Human;

public class DishWash extends Device{

    public DishWash(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }

    @Override
    public void useDevice(Human human) {

    }

    @Override
    public void repairDevice(Human human) {

    }

    @Override
    public void consume() {

    }

    @Override
    public int cleaning() {
        return 0;
    }

    @Override
    public int happiness() {
        return 0;
    }
}
