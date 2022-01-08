package event;

import devices.Device;
import enums.Activity;
import npc.Human;

import java.util.ArrayList;

public abstract class Event {

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

    public static ArrayList<Event> activitiesToDo = new ArrayList<>();
    public static ArrayList<Event> currentActivities = new ArrayList<>();
    public static ArrayList<Event> notifications = new ArrayList<>();
    public static ArrayList<Event> notReadyEvents = new ArrayList<>();

    public abstract boolean accept(EventVisitor visitor);

    public Device getUsingDevice() {
        return usingDevice;
    }

    public Human getHuman() {
        return human;
    }

    public int getDuration() {
        return duration;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Event{" +
                "usingDevice=" + usingDevice +
                ", human=" + human +
                ", duration=" + duration +
                ", activity=" + activity +
                '}';
    }
}
