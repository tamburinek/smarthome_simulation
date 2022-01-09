package manuals;

import event.Event;
import notification.BrokeNotification;

import java.util.List;

public class ManualProxyImpl implements Manual {

    private Manual manual;

    @Override
    public List<String> readingManual() {
        if (manual == null) {
            manual = new ManualImpl();
        }
        return manual.readingManual();
    }
}
