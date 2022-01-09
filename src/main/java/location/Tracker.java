package location;

/**
 * tracking something
 */
public abstract class Tracker {
    private Location location;

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isIn(Location location) {
        return this.location == location;
    }
}
