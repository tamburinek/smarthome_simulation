import devices.Device;
import devices.DeviceFactory;
import enums.Gender;
import house.*;
import iterator.ConfigurationIterator;
import manuals.Manual;
import manuals.ManualProxyImpl;
import npc.*;
import sensors.ResourceSensor;
import sensors.Sensor;
import strategy.HardStrategy;

import java.util.ArrayList;

public class HardRun {
    public static void main(String[] args) {

        ArrayList<Floor> floors = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Human> humans = new ArrayList<>();
        ArrayList<Sensor> sensors = new ArrayList<>();

        Manual manual = new ManualProxyImpl();

        ResourceSensor resourceSensor = new ResourceSensor();
        sensors.add(resourceSensor);

        //first floor
        Floor firstFloor = new Floor("first");

        Room garage = new Room("garage");
        Device car = DeviceFactory.createCar("car", 10, 0, 0, manual);
        garage.addDevice(car);
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
        Device babyDevice = DeviceFactory.createBabyDevice("baby ultimatum device", 10, 0, 90, manual);
        kidsRoom.addDevice(babyDevice);
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
        Human Bart = new Child("Bart", 19, Gender.MALE);
        Human Lisa = new Child("Lisa", 21, Gender.FEMALE);
        Human Mimino = new Baby("Mimino", 2, Gender.MALE);
        Human Mimino2 = new Baby("Mimino druhe", 3, Gender.MALE);
        Deda.setLocation(parentsRoom);
        Pepa.setLocation(garage);
        Iveta.setLocation(entry);
        BabickaIlona.setLocation(animalRoom);
        Honzik.setLocation(garage);
        Maruska.setLocation(kidsRoom);
        Mimino.setLocation(kidsRoom);

        Bart.setLocation(kidsRoom);
        Lisa.setLocation(parentsRoom);
        Mimino2.setLocation(kidsRoom);

        humans.add(Bart);
        humans.add(Lisa);
        humans.add(Mimino2);
        humans.add(Deda);
        humans.add(Pepa);
        humans.add(Iveta);
        humans.add(BabickaIlona);
        humans.add(Honzik);
        humans.add(Maruska);
        humans.add(Mimino);

        //animals
        Animal cat = new Cat("Mourek");
        Animal cat2 = new Cat("Kocourek");
        Animal dog1 = new Dog("DogeCoin");
        Animal dog3 = new Dog("Hrstka");
        Animal dog2 = new Dog("Bitcoin");
        Animal penguin = new Penguin("Penguin");
        Animal penguin2 = new Penguin("Penguinik");
        penguin2.setLocation(animalRoom);
        cat.setLocation(animalRoom);
        cat2.setLocation(animalRoom);
        dog1.setLocation(animalRoom);
        dog2.setLocation(animalRoom);
        dog3.setLocation(animalRoom);
        penguin.setLocation(animalRoom);
        animals.add(cat);
        animals.add(cat2);
        animals.add(dog3);
        animals.add(dog1);
        animals.add(dog2);
        animals.add(penguin);
        animals.add(penguin2);

        HouseBuilder builder = new HouseBuilder();
        House testHouse = builder.houseName("test").floors(floors).animals(animals).humans(humans).sensors(sensors).getResult();
        HouseController runner = new HouseController(testHouse, new HardStrategy());



        //running simulation
        runner.runSimulation(100);

        ConfigurationIterator iterator = new ConfigurationIterator(testHouse,"reports/hard/HouseConfigurationReport.txt");
        iterator.next();
        iterator.last();
    }
}
