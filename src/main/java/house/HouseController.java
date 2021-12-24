package house;

import utills.Time;

public class HouseController {

    private House house;

    public HouseController(House house) {
        this.house = house;
    }

    public static void runSimulation(){
        Time.setCurrentTime(1,1,1);
        for (int i = 0; i < 100; i++) {
            Time.addTime(10);
            System.out.println(Time.getCurrentTime());
        }
    }
}
