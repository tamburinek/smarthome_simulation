package devices;

public class Bed extends Device{

    public Bed(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
    }


    @Override
    public void consume(boolean usingDevice) {
        //consume nothing
    }

    @Override
    public int cleaning() {
        return -10;
    }

    @Override
    public int happiness() {
        return 100;
    }

    @Override
    public int fresh() {
        return 100;
    }
}
