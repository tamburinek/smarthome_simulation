package devices;

public class Light extends Device {
    public Light(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
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
