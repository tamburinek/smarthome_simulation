package house;

import devices.Device;
import location.Location;

import java.util.ArrayList;

public class Room extends Location {

    private final String roomName;

    private Floor floor;

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
        if (device.getLocation() == null){
            device.setLocation(this);
        }
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", devices=" + devices +
                '}';
    }
}
