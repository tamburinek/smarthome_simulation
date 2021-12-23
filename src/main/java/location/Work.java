package location;

public class Work extends Location{

    //singleton pattern
    private static final Work instance = new Work();

    public static Work getInstance() {
        return instance;
    }

    private Work(){

    }
}
