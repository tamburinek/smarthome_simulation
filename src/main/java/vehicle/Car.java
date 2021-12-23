package vehicle;

public class Car extends Vehicle{

    public Car(String deviceName, int repairDifficulty, int brokenIndex) {
        super(deviceName, repairDifficulty, brokenIndex);
    }

    @Override
    protected void consume() {

    }
}
