package utills;

import java.util.Calendar;
import java.util.Date;

/**
 * time necessary for reporting
 */
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
}
