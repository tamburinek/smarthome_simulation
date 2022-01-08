package observer;

import devices.Device;
import enums.NotificationType;
import event.Event;
import event.PrintingEvent;

public class DeviceObserver extends Observer{

    @Override
    public void update(NotificationType type) {
        if (type == NotificationType.STARTED_USING || type == NotificationType.ENDED_USING){
            Event.doneEvents.add(new PrintingEvent(device, device.getHumanUsingDevice(), device.getDuration(), type));
        }
    }

    public DeviceObserver(Device device) {
        super(device);
    }
}
