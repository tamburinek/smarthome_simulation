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
        double breakNumber = random.nextInt(100);
        if (using){
            numberToBeat = (numberToBeat * 0.1);
        }

        return breakNumber < numberToBeat;
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
        ArrayList<Device> devices1 = new ArrayList<>();
        for (Device device : devices) {
            if (device.getType() != DeviceType.WORK && device.getType() != DeviceType.EAT ) {
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
            if (human.getAge() > requiredAge && human.isDoingSt()) {
                humans1.add(human);
            }
        }
        if (!humans1.isEmpty()){
            return humans1.get(random.nextInt(humans1.size()));
        }
        return null;
    }
}
