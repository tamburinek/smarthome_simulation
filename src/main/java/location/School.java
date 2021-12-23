package location;

public class School extends Location{

    //singleton pattern
    private static final School instance = new School();

    public static School getInstance() {
        return instance;
    }

    private School(){

    }
}
