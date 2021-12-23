package devices;

public class Computer extends Device{

    public Computer(String deviceName, int repairDifficulty, int brokenIndex) {
        super(deviceName, repairDifficulty, brokenIndex);
    }

    @Override
    protected void consume() {

    }
}
