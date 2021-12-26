package event;

import devices.Device;
import enums.Activity;
import npc.Human;

public class RepairEvent extends Event{

    public RepairEvent(Device usingDevice, Human human, int duration, Activity activity) {
        super(usingDevice, human, duration, activity);
    }

    @Override
    public boolean accept(EventVisitor visitor) {
        return visitor.visitRepairEvent(this);
    }
}
