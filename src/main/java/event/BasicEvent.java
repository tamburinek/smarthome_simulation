package event;

import devices.Device;
import npc.Human;

public class BasicEvent extends Event{

    public BasicEvent(Device usingDevice, Human human, int duration) {
        super(usingDevice, human, duration);
    }

    @Override
    public boolean accept(EventVisitor visitor) {
        return visitor.visitBasicEvent(this);
    }
}
