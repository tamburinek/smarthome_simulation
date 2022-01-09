import devices.*;
import enums.Gender;
import house.*;
import manuals.Manual;
import manuals.ManualProxyImpl;
import npc.*;
import strategy.EasyStrategy;
import vehicle.Bike;

import java.util.ArrayList;


public class EasyRun {
    public static void main(String[] args) {

        ArrayList<Floor> floors = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Human> humans = new ArrayList<>();

        Manual manual = new ManualProxyImpl();

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
        Device bath = new Bath("bath", 23, 10, 60, manual);
        bathroom.addDevice(bath);
        Device bed = new Bed("bed", 10, 2, 50, manual);
        bathroom.addDevice(bed);

        Device clothWash = new ClothWash("cloth wash", 10, 2, 20, manual);
        bathroom.addDevice(clothWash);
        Device computer = new Computer("computer", 10, 2, 80, manual);
        bathroom.addDevice(computer);
        Device dishWash = new DishWash("dish wash", 10, 2, 40, manual);
        bathroom.addDevice(dishWash);
        Device phone = new Phone("phone", 10, 2, 35, manual);
        bathroom.addDevice(phone);
        Device radio = new Radio("radio", 10, 2, 90, manual);
        bathroom.addDevice(radio);
        Device bed2 = new Bed("bed2", 10, 2, 10, manual);
        bathroom.addDevice(bed2);
        Device tv = new Television("tv", 10, 2, 60, manual);
        bathroom.addDevice(tv);
        Device workingComputer = new WorkingComputer("work", 10, 2, 0, manual);
        bathroom.addDevice(workingComputer);
        Device refrigerator = new Refrigerator("refrigerator", 10, 2, 0, manual);
        bathroom.addDevice(refrigerator);
        Device refrigerator2 = new Refrigerator("refrigerator2", 10, 2, 0, manual);
        bathroom.addDevice(refrigerator2);
        Device refrigerator3 = new Refrigerator("refrigerator3", 10, 2, 0, manual);
        bathroom.addDevice(refrigerator3);
        Device bike = new Bike("bike", 10, 2, 0, manual);
        bathroom.addDevice(bike);

        secondFloor.addRoom(bathroom);
        floors.add(secondFloor);

        //third floor
        Floor thirdFloor = new Floor("third");
        floors.add(thirdFloor);

        //humans
        Human Pepa = new Adult("Pepa", 34, Gender.MALE);
        Human Iveta = new Adult("Iveta", 45, Gender.FEMALE);
        Human BabickaIlona = new Adult("Ilona", 69, Gender.FEMALE);
        Human Honzik = new Child("Honzik", 13, Gender.MALE);
        Human Maruska = new Child("Maruska", 15, Gender.FEMALE);
        Human Mimino = new Baby("Mimino", 2, Gender.MALE);
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
        HouseController runner = new HouseController(testHouse, new EasyStrategy());



        //running simulation
        runner.runSimulation(70);

    }
}
