package event;

import devices.Device;
import notification.Notification;
import npc.Human;
import utills.Time;

import java.util.ArrayList;
import java.util.Date;

public abstract class Event {

    private final Device usingDevice;
    private final Human human;
    private int duration;
    private final Date time;

    public Event(Device usingDevice, Human human, int duration) {
        this.usingDevice = usingDevice;
        this.human = human;
        this.duration = duration;
        this.time = Time.getCurrentTime();
    }

    public static ArrayList<Event> activitiesToDo = new ArrayList<>();
    public static ArrayList<Event> currentActivities = new ArrayList<>();
    public static ArrayList<Event> notifications = new ArrayList<>();

    public static ArrayList<Event> doneEvents = new ArrayList<>();
    public static ArrayList<Notification> allNotifications = new ArrayList<>();

    public abstract boolean accept(EventVisitor visitor);


    public Date getTime() {
        return time;
    }

    public Device getUsingDevice() {
        return usingDevice;
    }

    public Human getHuman() {
        return human;
    }

    public int getDuration() {
        return duration;
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
                '}';
    }
}
