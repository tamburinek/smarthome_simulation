package observer;

import devices.Device;
import enums.NotificationType;

public abstract class Observer {

    protected Device device;

    public abstract void update(NotificationType type);

    public Observer(Device device) {
        this.device = device;
        this.device.attach(this);
    }
}
