package devices;

public class Window extends Device {
    public Window(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }

    @Override
    protected void consume() {

    }
}
