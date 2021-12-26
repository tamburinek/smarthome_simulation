package devices;

public class DeviceFactory {

    public static Bath createBath(String name, int difficulty, int index, int effectivity){return new Bath(name, difficulty, index, effectivity);}
    public static ClothWash createClothWash(String name, int difficulty, int index, int effectivity){return new ClothWash(name, difficulty, index, effectivity);}
    public static Computer createComputer(String name, int difficulty, int index, int effectivity){return new Computer(name, difficulty, index, effectivity);}
    public static DishWash createDishWash(String name, int difficulty, int index, int effectivity){return new DishWash(name, difficulty, index, effectivity);}
    public static Light createLight(String name, int difficulty, int index, int effectivity){return new Light(name, difficulty, index, effectivity);}
    public static Phone createPhone(String name, int difficulty, int index, int effectivity){return new Phone(name, difficulty, index, effectivity);}
    public static Radio createRadio(String name, int difficulty, int index, int effectivity){return new Radio(name, difficulty, index, effectivity);}
    public static Refrigerator createRefrigerator(String name, int difficulty, int index, int effectivity){return new Refrigerator(name, difficulty, index, effectivity);}
    public static Sink createSink(String name, int difficulty, int index, int effectivity){return new Sink(name, difficulty, index, effectivity);}
    public static Television createTv(String name, int difficulty, int index, int effectivity){return new Television(name, difficulty, index, effectivity);}
    public static Window createWindow(String name, int difficulty, int index, int effectivity){return new Window(name, difficulty, index, effectivity);}
    public static WorkingComputer createWorkPc(String name, int difficulty, int index, int effectivity){return new WorkingComputer(name, difficulty, index, effectivity);}
}
