package event;

import devices.Device;
import npc.Baby;
import npc.Human;

public class BabyEvent extends Event{

    private final Baby baby;

    public BabyEvent(Device usingDevice, Human human, int duration, Baby baby) {
        super(usingDevice, human, duration);
        this.baby = baby;
    }

    @Override
    public boolean accept(EventVisitor visitor) {
        return visitor.visitBabyEvent(this);
    }

    public Baby getBaby() {
        return baby;
    }
}
