package iterator;

import event.Event;

import java.io.FileWriter;
import java.io.IOException;

public class NotificationIterator implements Iterator{

    private int index = 0;
    private final String file;

    public NotificationIterator(String file) {
        this.file = file;
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write("This is file of all notifications");
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
        return index < Event.allNotifications.size();
    }

    @Override
    public void next() {
        try {
            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write(index + 1 + ") " + Event.allNotifications.get(index).getReport());
            myWriter.write("\r\n");
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        index++;
    }

}
