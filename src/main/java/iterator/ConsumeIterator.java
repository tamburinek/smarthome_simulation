package iterator;

public class ConsumeIterator implements Iterator{

    private final String filename;
    private int index = 0;

    public ConsumeIterator(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void next() {

    }
}
