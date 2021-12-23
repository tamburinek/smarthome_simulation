package house;

import java.util.ArrayList;

public class Floor {

    private String name;

    public Floor(String name) {
        this.name = name;
    }

    private ArrayList<Room> rooms = new ArrayList<>();

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    @Override
    public String toString() {
        return "Floor{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
