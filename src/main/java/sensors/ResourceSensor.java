package sensors;

import enums.ResourceEnum;
import event.Event;
import notification.ResourceNotification;
import utills.Helper;
import utills.Time;

/**
 * sensor is checking if house has enough money and other resources
 */
public class ResourceSensor implements Sensor{

    /**
     * buys resources if necessary
     * @return true if there is not enough money
     */
    @Override
    public boolean isSomethingWrong() {
        if (ResourceEnum.FOOD.getQuantity() <= 100){
            ResourceEnum.FOOD.add(10000);
            Event.allNotifications.add(new ResourceNotification(Time.getCurrentTime() + " - i just bought 1000 units of food"));

        }
        if (ResourceEnum.WATER.getQuantity() <= 100){
            ResourceEnum.WATER.add(10000);
            Event.allNotifications.add(new ResourceNotification(Time.getCurrentTime() + " - i just bought 1000 units of water"));

        }
        if (ResourceEnum.ELECTRICITY.getQuantity() <= 100){
            ResourceEnum.ELECTRICITY.add(10000);
            Event.allNotifications.add(new ResourceNotification(Time.getCurrentTime() + " - i just bought 1000 units of electricity"));

        }
        if (ResourceEnum.GAS.getQuantity() <= 100){
            ResourceEnum.GAS.add(10000);
            Event.allNotifications.add(new ResourceNotification(Time.getCurrentTime() + " - i just bought 1000 units of gas"));

        }

        return ResourceEnum.MONEY.getQuantity() < 10000;
    }

    @Override
    public String getName() {
        return "resource sensor";
    }
}
