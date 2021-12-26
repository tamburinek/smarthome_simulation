package devices;

public class Sink extends Device{
    public Sink(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }

    @Override
    protected void consume() {

    }
}
