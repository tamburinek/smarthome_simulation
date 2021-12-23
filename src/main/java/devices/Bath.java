package devices;

public class Bath extends Device{

    public Bath(String deviceName, int repairDifficulty, int brokenIndex) {
        super(deviceName, repairDifficulty, brokenIndex);
    }

    @Override
    protected void consume() {

    }
}
