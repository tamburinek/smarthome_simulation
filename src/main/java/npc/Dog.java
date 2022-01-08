package npc;

public class Dog extends Animal{
    @Override
    public void playWithHuman(Human human) {
        setHappiness(getHappiness()+100);
    }

    public Dog(String name) {
        super(name);
    }
}
