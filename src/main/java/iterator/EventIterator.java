package iterator;

import enums.NotificationType;
import event.Event;
import event.PrintingEvent;
import npc.Animal;
import npc.Human;

import java.io.FileWriter;
import java.io.IOException;

public class EventIterator implements Iterator{

    private int index = 0;
    private String file;

    public EventIterator(String file) {
        this.file = file;
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write("This is file of all events");
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
        return index < Event.doneEvents.size();
    }

    @Override
    public void next() {

        PrintingEvent event = (PrintingEvent) Event.doneEvents.get(index);

        try {
            FileWriter myWriter = new FileWriter(file, true);
            if (event.getUsingDevice() == null && event.getType() == NotificationType.STARTED_USING ){
                myWriter.write(index + 1 + ") " + event.getTime() + " - " +  event.getHuman().getName() + " started playing with animal and will be doing it for " + event.getDuration());
            }
            else if (event.getType() == NotificationType.STARTED_USING_ANIMAL || event.getType() == NotificationType.ENDED_USING_ANIMAL){
                myWriter.write(index + 1 + ") " + event.getTime() + " - " + event.getType() + " " + event.getUsingDevice().getDeviceName());
            }
            else if (event.getUsingDevice() == null && event.getType() == NotificationType.ENDED_USING ){
                myWriter.write(index + 1 + ") " + event.getTime() + " - " +  event.getHuman().getName() + " ended playing with animal");
            }
            else if (event.getType() == NotificationType.STARTED_USING || event.getType() == NotificationType.STARTED_REPAIRING ){
                myWriter.write(index + 1 + ") " + event.getTime() + " - " + event.getHuman().getName() + " " + event.getType() +
                        " " + event.getUsingDevice().getDeviceName() + " and will be doing it for " + event.getDuration() + " minutes");
            }
            else if (event.getType() == NotificationType.BROKE_IN_IDLE){
                myWriter.write(index + 1 + ") " + event.getTime() + " - " + event.getUsingDevice().getDeviceName() + " " + event.getType());
            }
            else {
                myWriter.write(index + 1 + ") " + event.getTime() + " - " + event.getHuman().getName() + " " + event.getType() + " " + event.getUsingDevice().getDeviceName());
            }
            myWriter.write("\r\n");
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        index++;
    }

    public void last(Human human){
        try {
            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write("\r\n");
            myWriter.write(human.getName() + "'s stats after simulation are : "
                    + "hunger: " + human.getHungry()
                    + " clean: " + human.getClean()
                    + " happiness: " + human.getHappiness()
                    + " fresh: "+ human.getFresh());
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void lastAnimal(Animal animal){
        try {
            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write("\r\n");
            myWriter.write(animal.getName() + "'s stats after simulation are : "
                    + "hunger: " + animal.getHungry()
                    + " happiness: " + animal.getHappiness());
            myWriter.write("\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
