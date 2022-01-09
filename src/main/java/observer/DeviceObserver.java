package observer;

import devices.Device;
import enums.NotificationType;
import event.Event;
import event.PrintingEvent;

public class DeviceObserver extends Observer{

    @Override
    public void update(NotificationType type) {
        if (type == NotificationType.BROKE_IN_IDLE || type == NotificationType.STARTED_USING_ANIMAL || type == NotificationType.ENDED_USING_ANIMAL  ){
            Event.doneEvents.add(new PrintingEvent(device, null, device.getDuration(), type));
        }
        else{
            Event.doneEvents.add(new PrintingEvent(device, device.getHumanUsingDevice(), device.getDuration(), type));
        }
    }

    public DeviceObserver(Device device) {
        super(device);
    }
}
