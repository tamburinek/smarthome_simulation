package event;

import devices.Device;
import enums.NeedsType;
import npc.Human;

public class NeedsEvent extends Event{

    private final NeedsType type;

    public NeedsEvent(Human human, NeedsType type) {
        super(null, human, 0);
        this.type = type;
    }

    public NeedsType getType() {
        return type;
    }

    @Override
    public boolean accept(EventVisitor visitor) {
        return false;
    }
}
