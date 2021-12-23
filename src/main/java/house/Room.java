package house;

import devices.Device;
import location.Location;

import java.util.ArrayList;

public class Room extends Location {

    private final String roomName;
    private ArrayList<Device> devices = new ArrayList<>();

    public Room(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device){
        devices.add(device);
        device.changeLocation(this);
    }
}
