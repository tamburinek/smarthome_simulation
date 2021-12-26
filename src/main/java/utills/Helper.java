package utills;

import devices.Device;
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
        //todo
        return null;
    }

    public static Device findDeviceForJoy(ArrayList<Device> devices){
        //todo
        return null;
    }

    public static Device findDeviceForSleep(ArrayList<Device> devices){
        //todo
        return null;
    }

    public static Device findDeviceToEat(ArrayList<Device> devices){
        //todo
        return null;
    }

    public static Device findRandomDevice(ArrayList<Device> devices){
        //todo
        return null;
    }

    public static Device findVehicle(ArrayList<Device> devices){
        //todo
        return null;
    }

    public static Human findPersonForRepair(int required, ArrayList<Human> humans){
        //todo
        return null;
    }
}
