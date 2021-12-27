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

    public static Device findDeviceForClean(ArrayList<Device> devices){
        for (Device device : devices) {
            if (device.getType() == DeviceType.CLEANING) {
                if (!device.getState().isOccupied() && !device.getState().isBroken())
                    return device;
            }
        }
        return null;
    }

    public static Device findDeviceForJoy(ArrayList<Device> devices){
        for (Device device : devices) {
            if (device.getType() == DeviceType.JOY) {
                if (!device.getState().isOccupied() && !device.getState().isBroken())
                    return device;
            }
        }
        return null;
    }

    public static Device findDeviceForSleep(ArrayList<Device> devices){
        for (Device device : devices) {
            if (device.getType() == DeviceType.SLEEPING) {
                if (!device.getState().isOccupied() && !device.getState().isBroken())
                    return device;
            }
        }
        return null;
    }

    public static Device findDeviceToEat(ArrayList<Device> devices){
        for (Device device : devices) {
            if (device.getType() == DeviceType.EAT) {
                if (!device.getState().isOccupied() && !device.getState().isBroken())
                    return device;
            }
        }
        return null;
    }

    public static Device findRandomDevice(ArrayList<Device> devices){
        for (Device device : devices) {
            if (device.getType() == DeviceType.JOY || device.getType() == DeviceType.WORK || device.getType() == DeviceType.SPORT || device.getType() == DeviceType.EAT || device.getType() == DeviceType.SLEEPING) {
                if (!device.getState().isOccupied() && !device.getState().isBroken())
                    return device;
            }
        }
        return null;
    }

    public static Device findVehicle(ArrayList<Device> devices){
        for (Device device : devices) {
            if (device.getType() == DeviceType.TRANSPORT) {
                if (!device.getState().isOccupied() && !device.getState().isBroken())
                    return device;
            }
        }
        return null;
    }

    public static Human findPersonForRepair(int requiredAge, ArrayList<Human> humans){
        for (Human human : humans) {
            if (human.getAge() > requiredAge) {
                if (!human.isDoingSt())
                    return human;
            }
        }
        return null;
    }
}
