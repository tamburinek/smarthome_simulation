package devices;

import manuals.Manual;
import vehicle.Bike;
import vehicle.Car;

public class DeviceFactory {

    public static Bath createBath(String name, int difficulty, int index, int effectivity, Manual manual){return new Bath(name, difficulty, index, effectivity, manual);}

    public static Bed createBed(String name, int difficulty, int index, int effectivity, Manual manual){return new Bed(name, difficulty, index, effectivity, manual);}

    public static ClothWash createClothWash(String name, int difficulty, int index, int effectivity, Manual manual){return new ClothWash(name, difficulty, index, effectivity, manual);}

    public static Computer createComputer(String name, int difficulty, int index, int effectivity, Manual manual){return new Computer(name, difficulty, index, effectivity, manual);}

    public static DishWash createDishWash(String name, int difficulty, int index, int effectivity, Manual manual){return new DishWash(name, difficulty, index, effectivity, manual);}

    public static Light createLight(String name, int difficulty, int index, int effectivity, Manual manual){return new Light(name, difficulty, index, effectivity, manual);}

    public static Phone createPhone(String name, int difficulty, int index, int effectivity, Manual manual){return new Phone(name, difficulty, index, effectivity, manual);}

    public static Radio createRadio(String name, int difficulty, int index, int effectivity, Manual manual){return new Radio(name, difficulty, index, effectivity, manual);}

    public static Refrigerator createRefrigerator(String name, int difficulty, int index, int effectivity, Manual manual){return new Refrigerator(name, difficulty, index, effectivity, manual);}

    public static Sink createSink(String name, int difficulty, int index, int effectivity, Manual manual){return new Sink(name, difficulty, index, effectivity, manual);}

    public static Television createTv(String name, int difficulty, int index, int effectivity,Manual manual){return new Television(name, difficulty, index, effectivity, manual);}

    public static Window createWindow(String name, int difficulty, int index, int effectivity, Manual manual){return new Window(name, difficulty, index, effectivity, manual);}

    public static WorkingComputer createWorkPc(){return new WorkingComputer("work", 0, 0, 0);}

    public static Bike createBike(String name, int difficulty, int index, int effectivity,Manual manual){return new Bike(name, difficulty, index, effectivity, manual);}

    public static Car createCar(String name, int difficulty, int index, int effectivity,Manual manual){return new Car(name, difficulty, index, effectivity, manual);}

}
