package event;

import devices.Device;
import enums.Activity;
import npc.Human;

import java.util.ArrayList;

public class Event {

    private final Device usingDevice;
    private final Human human;
    private int duration;
    private Activity activity;

    public Event(Device usingDevice, Human human, int duration, Activity activity) {
        this.usingDevice = usingDevice;
        this.human = human;
        this.duration = duration;
        this.activity = activity;
    }

    //todo here will be listener pattern

    public static ArrayList<Event> eventsToDo = new ArrayList<>();
    public static ArrayList<Event> currentEvents = new ArrayList<>();
    public static ArrayList<Event> notifications = new ArrayList<>();

}