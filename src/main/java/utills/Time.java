package utills;

import java.util.Calendar;
import java.util.Date;

public class Time {

    public static Calendar calendar = Calendar.getInstance();

    public static void addTime(int minutes){
        calendar.add(Calendar.MINUTE, minutes);
    }

    public static Date getCurrentTime(){
        return calendar.getTime();
    }

    public static void setCurrentTime(int year, int month, int day){
        calendar.set(year, month - 1, day, 0, 0, 0);
    }

    public static void runSimulation(){
        setCurrentTime(1,1,1);
        for (int i = 0; i < 100; i++) {
            addTime(10);
            System.out.println(getCurrentTime());
        }
    }
}
