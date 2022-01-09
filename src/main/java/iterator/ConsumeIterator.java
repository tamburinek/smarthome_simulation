package iterator;

import devices.Device;
import enums.ResourceEnum;
import event.Event;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ConsumeIterator implements Iterator{

    private final String filename;
    private int index = 0;
    private final ArrayList<Device> devices;

    public ConsumeIterator(String filename, ArrayList<Device> devices) {
        this.filename = filename;
        this.devices = devices;
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write("This is file of all consumes");
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
        return index < devices.size();
    }

    @Override
    public void next() {
        Device device = devices.get(index);
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            myWriter.write(index + 1 + ") " + device.getDeviceName() + " consumed "
                    + device.getResourcesConsumed()[0] + " electricity and " + device.getResourcesConsumed()[1] + " gas and " +
                    device.getResourcesConsumed()[2] + " water");
            myWriter.write("\r\n");
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        index++;
    }

    public void last(){
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            myWriter.write("all consumed electricity " + ResourceEnum.ELECTRICITY.consumedEnd());
            myWriter.write("\r\n");
            myWriter.write("all consumed food " + ResourceEnum.FOOD.consumedEnd());
            myWriter.write("\r\n");
            myWriter.write("all consumed water " + ResourceEnum.WATER.consumedEnd());
            myWriter.write("\r\n");
            myWriter.write("all consumed gas " + ResourceEnum.GAS.consumedEnd());
            myWriter.write("\r\n");
            myWriter.write("all consumed money " + ResourceEnum.MONEY.consumedEnd());
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
