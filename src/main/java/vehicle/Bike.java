package vehicle;

public class Bike extends Vehicle{

    public Bike(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }

    @Override
    public void consume(boolean usingDevice) {
        //consume nothing
    }

    @Override
    public int cleaning() {
        return -30;
    }

    @Override
    public int happiness() {
        return 30;
    }

    @Override
    public int fresh() {
        return -20;
    }
}
