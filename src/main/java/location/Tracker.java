package location;

public abstract class Tracker {
    private Location location;

    public void changeLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isIn(Location location) {
        return this.location == location;
    }
}
