package iterator;

import devices.Device;
import house.Floor;
import house.House;
import house.Room;
import npc.Animal;
import npc.Human;

import java.io.FileWriter;
import java.io.IOException;

public class ConfigurationIterator implements Iterator{

    private House house;
    private String filename;

    public ConfigurationIterator(House house, String file) {
        this.house = house;
        this.filename = file;
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write("This is file of house configuration");
            myWriter.write("\r\n");
            myWriter.write("------------------------------------");
            myWriter.write("\r\n");
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public void writeHouse(String textToWrite){
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            myWriter.write(textToWrite);
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void next() {
        writeHouse("House:");
        for (Floor floor: house.getFloors()) {
            writeHouse("     Floor: " + floor.getName());
            for (Room room : floor.getRooms()) {
                    writeHouse("          Room: " + room.getRoomName());
                    writeHouse("               Devices:");
                for (Device device : room.getDevices()) {
                    writeHouse("                    " + device.getDeviceName());
                }
            }
        }
    }

    private void writeHumAni(String textToWrite){
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            myWriter.write("     " + textToWrite);
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void last(){
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            myWriter.write("\r\n");
            myWriter.write("Human and Animals:");
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (Human human : house.getHumans()) {
            writeHumAni(human.getName());
        }

        for (Animal animal : house.getAnimals()) {
            writeHumAni(animal.getName());
        }
    }
}
