package event;

import devices.Device;
import enums.Activity;
import npc.Animal;



public class AnimalEvent extends Event{
    private final Animal animal;

    public AnimalEvent(Device usingDevice, Animal animal, int duration, Activity activity) {
        super(usingDevice, null, duration, activity);
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    @Override
    public boolean accept(EventVisitor visitor) {
        return false;
    }
}
