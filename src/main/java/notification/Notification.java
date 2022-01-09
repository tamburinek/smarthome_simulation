package notification;

public abstract class Notification {

    private final String report;

    public Notification(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }
}
