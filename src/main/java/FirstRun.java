import enums.Difficulty;
import house.Floor;
import house.House;
import house.HouseBuilder;
import house.Room;
import npc.*;

import java.util.ArrayList;

public class FirstRun {
    public static void main(String[] args) {

        //setting difficulty
        Difficulty difficulty = Difficulty.EASY;
        difficulty.configure();

        ArrayList<Floor> floors = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Human> humans = new ArrayList<>();

        //first floor
        Floor firstFloor = new Floor();
        Room garage = new Room("garage");
        Room entry = new Room("entry");
        firstFloor.addRoom(garage);
        firstFloor.addRoom(entry);
        floors.add(firstFloor);

        //second floor
        Floor secondFloor = new Floor();
        floors.add(secondFloor);

        //third floor
        Floor thirdFloor = new Floor();
        floors.add(thirdFloor);

        //humans
        Human Pepa = new Adult("Pepa", 34);
        Human Iveta = new Adult("Iveta", 45);
        Human BabickaIlona = new Adult("Ilona", 69);
        Human Honzik = new Child("Honzik", 13);
        Human Maruska = new Child("Maruska", 15);
        Human Mimino = new Baby("Mimino", 2);

        humans.add(Pepa);
        humans.add(Iveta);
        humans.add(BabickaIlona);
        humans.add(Honzik);
        humans.add(Maruska);
        humans.add(Mimino);

        //animals
        Animal cat = new Cat("Mourek");
        Animal dog1 = new Dog("DogeCoin");
        Animal dog2 = new Dog("Bitcoin");

        animals.add(cat);
        animals.add(dog1);
        animals.add(dog2);

        HouseBuilder builder = new HouseBuilder();
        House testHouse = builder.houseName("test").floors(floors).animals(animals).humans(humans).getResult();
        System.out.println(testHouse);
    }
}
