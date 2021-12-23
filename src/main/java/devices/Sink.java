package devices;

public class Sink extends Device{
    public Sink(String deviceName, int repairDifficulty, int brokenIndex) {
        super(deviceName, repairDifficulty, brokenIndex);
    }

    @Override
    protected void consume() {

    }
}
