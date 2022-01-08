package event;

import devices.Device;
import npc.Human;

public class RepairEvent extends Event{

    private int solution;

    public RepairEvent(Device usingDevice, Human human, int duration) {
        super(usingDevice, human, duration);
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
