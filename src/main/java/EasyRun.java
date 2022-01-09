import devices.*;
import enums.Gender;
import house.*;
import iterator.ConfigurationIterator;
import manuals.Manual;
import manuals.ManualProxyImpl;
import npc.*;
import strategy.EasyStrategy;

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
        Device car = DeviceFactory.createCar("car", 10, 0, 0, manual);
        garage.addDevice(car);
        Device ski = DeviceFactory.createSki("ski", 10,0,0,manual);
        garage.addDevice(ski);
        Device light = DeviceFactory.createLight("garage light", 10, 0, 0, manual);
        garage.addDevice(light);
        Room entry = new Room("entry");
        Device bike = DeviceFactory.createBike("first bike", 10, 0, 0, manual);
        Device bike2 = DeviceFactory.createBike("second bike", 10, 0, 0, manual);
        entry.addDevice(bike);
        entry.addDevice(bike2);
        Device entryLight = DeviceFactory.createLight("entry light", 10, 0, 0, manual);
        entry.addDevice(entryLight);
        Room animalRoom = new Room("animal room");
        Device animalLight = DeviceFactory.createLight("animal light", 10, 0, 0, manual);
        animalRoom.addDevice(animalLight);
        Device refrigerator = DeviceFactory.createRefrigerator("refrigerator", 20, 0, 50, manual);
        animalRoom.addDevice(refrigerator);
        Device animalRefrigerator = DeviceFactory.createAnimalRef("animal refrigerator", 20, 0, 50, manual);
        animalRoom.addDevice(animalRefrigerator);

        firstFloor.addRoom(animalRoom);
        firstFloor.addRoom(garage);
        firstFloor.addRoom(entry);
        floors.add(firstFloor);

        //second floor
        Floor secondFloor = new Floor("second");

        Room toiletRoom = new Room("toilet");
        Device toilet = DeviceFactory.createToilet("toilet", 23, 0, 90, manual);
        toiletRoom.addDevice(toilet);
        Device toiletLight = DeviceFactory.createLight("toilet light", 10, 0, 0, manual);
        toiletRoom.addDevice(toiletLight);
        Room bathroom = new Room("bathroom");
        Device bathLight = DeviceFactory.createLight("bathroom light", 10, 0, 0, manual);
        bathroom.addDevice(bathLight);
        Device bath = DeviceFactory.createBath("bath", 23, 0, 60, manual);
        bathroom.addDevice(bath);
        Device clothWash = DeviceFactory.createClothWash("cloth wash", 10, 0, 60, manual);
        bathroom.addDevice(clothWash);
        Device dishWash = DeviceFactory.createDishWash("dish wash", 20, 0, 40, manual);
        bathroom.addDevice(dishWash);
        Device workingComputer = DeviceFactory.createWorkPc();
        bathroom.addDevice(workingComputer);

        Room kitchen = new Room("kitchen");
        Device kitchenLight = DeviceFactory.createLight("kitchen light", 10, 0, 0, manual);
        kitchen.addDevice(kitchenLight);
        Device refrigerator2 = DeviceFactory.createRefrigerator("refrigerator2", 40, 0, 50, manual);
        kitchen.addDevice(refrigerator2);
        Device refrigerator3 = DeviceFactory.createRefrigerator("refrigerator3", 60, 0, 50, manual);
        kitchen.addDevice(refrigerator3);

        secondFloor.addRoom(toiletRoom);
        secondFloor.addRoom(kitchen);
        secondFloor.addRoom(bathroom);
        floors.add(secondFloor);

        //third floor
        Floor thirdFloor = new Floor("third");
        Room kidsRoom = new Room("kids room");
        Device kidsRoomLight = DeviceFactory.createLight("kids room light", 10, 0, 0, manual);
        kidsRoom.addDevice(kidsRoomLight);
        Device bed = DeviceFactory.createBed("bed", 10, 0, 50, manual);
        kidsRoom.addDevice(bed);
        Device phone = DeviceFactory.createPhone("phone", 10, 0, 35, manual);
        kidsRoom.addDevice(phone);
        Device radio = DeviceFactory.createRadio("radio", 10, 0, 90, manual);
        kidsRoom.addDevice(radio);
        thirdFloor.addRoom(kidsRoom);

        Room parentsRoom = new Room("parents room");
        Device parents_room_light = DeviceFactory.createLight("parents room light", 10, 0, 0, manual);
        parentsRoom.addDevice(parents_room_light);
        Device bed2 = DeviceFactory.createBed("bed2", 10, 0, 30, manual);
        parentsRoom.addDevice(bed2);
        Device tv = DeviceFactory.createTv("tv", 10, 0, 60, manual);
        parentsRoom.addDevice(tv);
        Device computer = DeviceFactory.createComputer("computer", 20, 0, 80, manual);
        parentsRoom.addDevice(computer);

        thirdFloor.addRoom(parentsRoom);
        floors.add(thirdFloor);

        //humans
        Human Pepa = new Adult("Pepa", 34, Gender.MALE);
        Human Iveta = new Adult("Iveta", 45, Gender.FEMALE);
        Human BabickaIlona = new Adult("Ilona", 69, Gender.FEMALE);
        Human Deda = new Adult("Oldrich", 71, Gender.MALE);
        Human Honzik = new Child("Honzik", 13, Gender.MALE);
        Human Maruska = new Child("Maruska", 15, Gender.FEMALE);
        Human Mimino = new Baby("Mimino", 2, Gender.MALE);
        Deda.setLocation(parentsRoom);
        Pepa.setLocation(garage);
        Iveta.setLocation(entry);
        BabickaIlona.setLocation(animalRoom);
        Honzik.setLocation(garage);
        Maruska.setLocation(kidsRoom);
        Mimino.setLocation(kidsRoom);

        humans.add(Deda);
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
        runner.runSimulation(100);

        ConfigurationIterator iterator = new ConfigurationIterator(testHouse,"reports/easy/HouseConfigurationReport.txt");
        iterator.next();
        iterator.last();
    }
}
