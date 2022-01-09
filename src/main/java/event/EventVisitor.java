package event;

import enums.NotificationType;
import notification.BrokeNotification;

public class EventVisitor implements Visitor {

    public boolean visitBabyEvent(BabyEvent event){

        if (Event.activitiesToDo.contains(event) || Event.notifications.contains(event)) {
            if (event.getHuman().isIn(event.getUsingDevice().getLocation())) {
                if (!event.getHuman().isDoingSt() && !event.getBaby().isDoingSt()) {
                    event.getUsingDevice().startUsingDevice(event.getHuman());
                    event.getBaby().setDoingSt(true);
                    event.getHuman().setDoingSt(true);
                    Event.currentActivities.add(event);
                    return true;
                } else
                    return false;
            } else {
                event.getHuman().setLocation(event.getBaby().getLocation());
                return false;
            }
        }

        if (Event.currentActivities.contains(event)) {
            event.setDuration(event.getDuration() - 10);
            if (event.getDuration() <= 0) {
                event.getBaby().setDoingSt(false);
                event.getUsingDevice().stopUsingDevice(event.getHuman());
                return true;
            }
        }
        return false;
    }

    public boolean visitBasicEvent(BasicEvent event){

        if (Event.activitiesToDo.contains(event) || Event.notifications.contains(event)) {
            if (event.getHuman().isIn(event.getUsingDevice().getLocation())) {
                if (!event.getUsingDevice().getState().isOccupied() && !event.getUsingDevice().getState().isBroken()) {
                    event.getUsingDevice().startUsingDevice(event.getHuman());
                    Event.currentActivities.add(event);
                    return true;
                } else
                    return false;
            } else {
                event.getHuman().setLocation(event.getUsingDevice().getLocation());
                return false;
            }
        }

        if (Event.currentActivities.contains(event)) {
            event.setDuration(event.getDuration() - 10);
            if (event.getDuration() <= 0) {
                event.getHuman().claimSatisfy(event.getUsingDevice());
                event.getUsingDevice().stopUsingDevice(event.getHuman());
                return true;
            }
        }
        return false;
    }

    public boolean visitRepairEvent(RepairEvent event){
        if (Event.activitiesToDo.contains(event) || Event.notifications.contains(event)) {
            if (!event.getUsingDevice().getState().isBroken() || event.getUsingDevice().getHumanUsingDevice() != null){
                return true;
            }
            if (event.getHuman().isIn(event.getUsingDevice().getLocation())) {
                if (!event.getHuman().isDoingSt()) {
                    event.getHuman().setDoingSt(true);
                    event.getUsingDevice().setHumanUsingDevice(event.getHuman());
                    Event.doneEvents.add(new PrintingEvent(event.getUsingDevice(), event.getHuman(), event.getUsingDevice().getRepairDifficulty(), NotificationType.STARTED_REPAIRING));
                    Event.currentActivities.add(event);
                    event.getUsingDevice().getManual().readingManual();
                    Event.allNotifications.add(new BrokeNotification("Reading manual for " + event.getUsingDevice().getDeviceName()));
                    return true;
                } else
                    return false;
            } else {
                event.getHuman().setLocation(event.getUsingDevice().getLocation());
                return false;
            }
        }
        else if (Event.currentActivities.contains(event)) {
            event.setDuration(event.getDuration() - 10);
            if (event.getDuration() <= 0) {
                Event.doneEvents.add(new PrintingEvent(event.getUsingDevice(), event.getHuman(), 0, NotificationType.ENDED_REPAIRING));
                event.getUsingDevice().repairDevice(event.getHuman());
                return true;
            }
        }
        return false;
    }

    public boolean visitAnimalEvent(AnimalEvent event){
        if (Event.activitiesToDo.contains(event) || Event.notifications.contains(event)) {
            if (event.getHuman() == null){
                if (!event.getAnimal().isDoingSt() && !event.getUsingDevice().getState().isOccupied()){
                    Event.doneEvents.add(new PrintingEvent(event.getUsingDevice(),null, event.getDuration(),NotificationType.STARTED_USING_ANIMAL));
                    Event.currentActivities.add(event);
                    event.getAnimal().setDoingSt(true);
                    return true;
                }
            }else {
                if (event.getHuman().isIn(event.getAnimal().getLocation())) {
                    if (!event.getHuman().isDoingSt() && !event.getAnimal().isDoingSt()) {
                        event.getAnimal().setDoingSt(true);
                        event.getHuman().setDoingSt(true);
                        Event.currentActivities.add(event);
                        Event.doneEvents.add(new PrintingEvent(null,event.getHuman(), event.getDuration(),NotificationType.STARTED_USING));
                        return true;
                    } else
                        return false;
                } else {
                    event.getHuman().setLocation(event.getAnimal().getLocation());
                    return false;
                }
            }
        }

        if (Event.currentActivities.contains(event)) {
            event.setDuration(event.getDuration() - 10);
            if (event.getDuration() <= 0) {
                if (event.getHuman() != null){
                    event.getHuman().setDoingSt(false);
                    event.getAnimal().setDoingSt(false);
                    event.getAnimal().claimSatisfy(event.getHuman());
                    Event.doneEvents.add(new PrintingEvent(null,event.getHuman(), event.getDuration(),NotificationType.ENDED_USING));
                }
                else{
                    event.getAnimal().setDoingSt(false);
                    event.getAnimal().claimSatisfy(event.getUsingDevice());
                    Event.doneEvents.add(new PrintingEvent(event.getUsingDevice(), null, event.getDuration(),NotificationType.ENDED_USING_ANIMAL));
                }
                return true;
            }
        }
        return false;
    }
}
