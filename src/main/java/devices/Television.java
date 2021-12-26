package devices;

public class Television extends Device{
    public Television(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }

    @Override
    protected void consume() {

    }
}
