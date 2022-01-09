package utills;

import devices.Device;
import enums.DeviceType;
import npc.Human;

import java.util.ArrayList;
import java.util.Random;

public class Helper {

    public static Random random = new Random();

    public static boolean breakDevice(Device device, boolean using){
        double numberToBeat = device.getBrokenIndex();
        double breakNumber = random.nextInt(200);
        if (using){
            breakNumber = (breakNumber / 2);
        }

        return breakNumber < numberToBeat;
    }

    public static boolean makeSound(){
        double number = random.nextInt(100);
        return number % 11 == 0;
    }

    public static Device findDevice(ArrayList<Device> devices, DeviceType type){
        ArrayList<Device> devices1 = new ArrayList<>();
        for (Device device : devices) {
            if (device.getType() == type) {
                if (!device.getState().isOccupied() && !device.getState().isBroken())
                    devices1.add(device);
            }
        }
        if (!devices1.isEmpty()){
            return devices1.get(random.nextInt(devices1.size()));
        }
        return null;
    }

    public static Device findRandomDevice(ArrayList<Device> devices){
        if (random.nextBoolean()){
            return findDevice(devices, DeviceType.SPORT);
        }
        ArrayList<Device> devices1 = new ArrayList<>();
        for (Device device : devices) {
            if (device.getType() != DeviceType.WORK && device.getType() != DeviceType.LIGHT && device.getType() != DeviceType.ANIMAL && device.getType() != DeviceType.BABY) {
                if (!device.getState().isOccupied() && !device.getState().isBroken())
                    devices1.add(device);
            }
        }
        if (!devices1.isEmpty()){
            return devices1.get(random.nextInt(devices1.size()));
        }
        return null;
    }


    public static Human findPersonForActivity(int requiredAge, ArrayList<Human> humans){
        ArrayList<Human> humans1 = new ArrayList<>();
        for (Human human : humans) {
            if (human.getAge() > requiredAge) {
                humans1.add(human);
            }
        }
        if (!humans1.isEmpty()){
            return humans1.get(random.nextInt(humans1.size()));
        }
        return null;
    }
}
