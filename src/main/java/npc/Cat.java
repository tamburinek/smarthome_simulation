package npc;

public class Cat extends Animal{

    @Override
    public void playWithHuman(Human human) {
        setHappiness(getHappiness()+80);
    }

    public Cat(String name) {
        super(name);
    }
}
