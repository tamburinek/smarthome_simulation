package observer;

import devices.Device;
import enums.NotificationType;
import event.Event;
import event.NotificationEvent;
import utills.Time;

public class DeviceObserver extends Observer{

    @Override
    public void update(NotificationType type) {
        if (type == NotificationType.STARTED_USING || type == NotificationType.ENDED_USING){
            Event.doneEvents.add(new NotificationEvent(device, device.getHumanUsingDevice(), device.getDuration(), type));
        }
    }

    public DeviceObserver(Device device) {
        super(device);
    }
}
