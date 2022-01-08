package event;

import devices.Device;
import enums.NotificationType;
import npc.Human;

import java.util.Date;

public class NotificationEvent extends Event {

    private final NotificationType type;

    public NotificationEvent(Device usingDevice, Human human, int duration, NotificationType type) {
        super(usingDevice, human, duration);
        this.type = type;
    }

    public NotificationType getType() {
        return type;
    }

    @Override
    public boolean accept(EventVisitor visitor) {
        return false;
    }
}
