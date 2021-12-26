package event;

import devices.Device;
import enums.Activity;
import npc.Human;

public class BasicEvent extends Event{

    public BasicEvent(Device usingDevice, Human human, int duration, Activity activity) {
        super(usingDevice, human, duration, activity);
    }

    @Override
    public boolean accept(EventVisitor visitor) {
        return visitor.visitBasicEvent(this);
    }
}
