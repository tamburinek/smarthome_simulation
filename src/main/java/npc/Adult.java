package npc;

import devices.Device;
import enums.Gender;

public class Adult extends Human {

    public Adult(String name, int age, Gender gender) {
        super(name, age, gender, "hey bring me some beer");
    }
}
