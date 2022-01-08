package event;

import devices.Device;
import npc.Animal;
import npc.Human;


public class AnimalEvent extends Event{
    private final Animal animal;

    public AnimalEvent(Device usingDevice, Human human, Animal animal, int duration) {
        super(usingDevice, human, duration);
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
