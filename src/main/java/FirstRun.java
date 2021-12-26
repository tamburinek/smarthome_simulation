import devices.Bath;
import devices.Device;
import house.*;
import npc.*;

import java.util.ArrayList;

public class FirstRun {
    public static void main(String[] args) {

        ArrayList<Floor> floors = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Human> humans = new ArrayList<>();

        //first floor
        Floor firstFloor = new Floor("first");

        Room garage = new Room("garage");
        Room entry = new Room("entry");
        Room animalRoom = new Room("animal room");

        firstFloor.addRoom(animalRoom);
        firstFloor.addRoom(garage);
        firstFloor.addRoom(entry);
        floors.add(firstFloor);

        //second floor
        Floor secondFloor = new Floor("second");

        Room bathroom = new Room("bathroom");
        Device bath = new Bath("bath", 23, 25, 25);
        bath.setLocation(bathroom);
        bathroom.addDevice(bath);
        secondFloor.addRoom(bathroom);
        floors.add(secondFloor);

        //third floor
        Floor thirdFloor = new Floor("third");
        floors.add(thirdFloor);

        //humans
        Human Pepa = new Adult("Pepa", 34);
        Human Iveta = new Adult("Iveta", 45);
        Human BabickaIlona = new Adult("Ilona", 69);
        Human Honzik = new Child("Honzik", 13);
        Human Maruska = new Child("Maruska", 15);
        Human Mimino = new Baby("Mimino", 2);
        Pepa.setLocation(garage);
        Iveta.setLocation(entry);
        BabickaIlona.setLocation(animalRoom);
        Honzik.setLocation(garage);
        Maruska.setLocation(garage);
        Mimino.setLocation(garage);


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
        cat.setLocation(animalRoom);
        dog1.setLocation(animalRoom);
        dog2.setLocation(animalRoom);
        animals.add(cat);
        animals.add(dog1);
        animals.add(dog2);

        HouseBuilder builder = new HouseBuilder();
        House testHouse = builder.houseName("test").floors(floors).animals(animals).humans(humans).getResult();
        HouseController runner = new HouseController(testHouse);

        //running simulation
        runner.runSimulation(1);

    }
}
