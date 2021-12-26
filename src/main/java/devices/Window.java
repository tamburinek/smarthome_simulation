package devices;

public class Window extends Device {
    public Window(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }

    @Override
    public void consume(boolean usingDevice) {

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
}
