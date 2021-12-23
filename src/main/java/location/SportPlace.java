package location;

public class SportPlace extends Location{

    //singleton pattern
    private static final SportPlace instance = new SportPlace();

    public static SportPlace getInstance() {
        return instance;
    }

    private SportPlace(){

    }
}
