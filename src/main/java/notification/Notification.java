package notification;

/**
 * notification that humans or animals did
 */
public abstract class Notification {

    private final String report;

    public Notification(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }
}
