package location;

import house.House;

public class Outside extends Location {

    //singleton pattern
    private static final Outside instance = new Outside();

    public static Outside getInstance() {
        return instance;
    }

    private Outside(){

    }
}
