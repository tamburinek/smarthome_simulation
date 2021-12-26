package devices;

public class Phone extends Device{
    public Phone(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }

    @Override
    protected void consume() {

    }
}
