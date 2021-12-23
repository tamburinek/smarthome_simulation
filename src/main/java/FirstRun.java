import house.Floor;
import house.House;
import house.HouseBuilder;
import house.Room;
import npc.Adult;
import npc.Animal;
import npc.Cat;
import npc.Human;

import java.util.ArrayList;

public class FirstRun {
    public static void main(String[] args) {
        ArrayList<Floor> floors = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Human> humans = new ArrayList<>();

        //first floor
        Floor firstFloor = new Floor();
        Room garage = new Room("garage");
        firstFloor.addRoom(garage);
        floors.add(firstFloor);

        //second floor
        Floor secondFloor = new Floor();
        floors.add(secondFloor);

        //third floor
        Floor thirdFloor = new Floor();
        floors.add(thirdFloor);

        //humans
        humans.add(new Adult("Pepa", 34));

        //animals
        animals.add(new Cat());

        HouseBuilder builder = new HouseBuilder();
        House testHouse = builder.houseName("test").floors(floors).animals(animals).humans(humans).getResult();
        System.out.println(testHouse);
    }
}
