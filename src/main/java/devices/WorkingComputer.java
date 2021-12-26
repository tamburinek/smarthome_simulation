package devices;

import location.Work;
import npc.Human;

public class WorkingComputer extends Device{

    public WorkingComputer(String deviceName, int repairDifficulty, int brokenIndex, int effectivity) {
        super(deviceName, repairDifficulty, brokenIndex, effectivity);
        setLocation(Work.getInstance());
    }

    @Override
    public void consume() {

    }

    @Override
    public int cleaning() {
        return 0;
    }

    @Override
    public int happiness() {
        return 0;
    }
}
