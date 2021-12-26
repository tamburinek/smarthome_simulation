package devices;

public class Refrigerator extends Device {
    public Refrigerator(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }

    @Override
    protected void consume() {

    }
}
