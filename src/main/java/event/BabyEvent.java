package event;

import devices.Device;
import enums.Activity;
import npc.Baby;
import npc.Human;

public class BabyEvent extends Event{

    private final Baby baby;

    public BabyEvent(Device usingDevice, Human human, int duration, Activity activity, Baby baby) {
        super(usingDevice, human, duration, activity);
        this.baby = baby;
    }

    @Override
    public boolean accept(EventVisitor visitor) {
        return visitor.visitBabyEvent(this);
    }
}
