package house;

import java.util.ArrayList;

public class Floor {

    private String name;
    private House house;

    public Floor(String name) {
        this.name = name;
    }

    private ArrayList<Room> rooms = new ArrayList<>();

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room){
        room.setFloor(this);
        rooms.add(room);
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
