package devices;

public class Refrigerator extends Device {
    public Refrigerator(String deviceName, int repairDifficulty, int brokenIndex) {
        super(deviceName, repairDifficulty, brokenIndex);
    }

    @Override
    protected void consume() {

    }
}
