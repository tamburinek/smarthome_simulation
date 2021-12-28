package event;

import devices.Device;
import enums.Activity;
import npc.Human;

public class RepairEvent extends Event{

    private int solution;

    public RepairEvent(Device usingDevice, Human human, int duration, Activity activity) {
        super(usingDevice, human, duration, activity);
        solution = 0;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    @Override
    public boolean accept(EventVisitor visitor) {
        return visitor.visitRepairEvent(this);
    }
}
