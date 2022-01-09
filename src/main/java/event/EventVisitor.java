package event;

import enums.NotificationType;

import java.util.Random;

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
            if (!event.getUsingDevice().getState().isBroken()){
                return true;
            }

            if (event.getHuman().isIn(event.getUsingDevice().getLocation())) {
                if (!event.getHuman().isDoingSt()) {
                    event.getUsingDevice().repairDevice(event.getHuman());
                    Event.doneEvents.add(new PrintingEvent(event.getUsingDevice(), event.getHuman(), 0, NotificationType.ENDED_REPAIRING));
                    return true;
                } else
                    return false;
            } else {
                event.getHuman().setLocation(event.getUsingDevice().getLocation());
                return false;
            }
    }

    public boolean animalEvent(AnimalEvent event){
        if (Event.activitiesToDo.contains(event) || Event.notifications.contains(event)) {
            if (event.getHuman().isIn(event.getAnimal().getLocation())) {
                if (!event.getHuman().isDoingSt() && !event.getAnimal().isDoingSt()) {
                    event.getAnimal().setDoingSt(true);
                    event.getHuman().setDoingSt(true);
                    Event.currentActivities.add(event);
                    return true;
                } else
                    return false;
            } else {
                event.getHuman().setLocation(event.getAnimal().getLocation());
                return false;
            }
        }
        if (Event.currentActivities.contains(event)) {
            event.setDuration(event.getDuration() - 10);
            if (event.getDuration() <= 0) {
                Event.currentActivities.remove(event);
                event.getHuman().setDoingSt(false);
                event.getAnimal().setDoingSt(false);
                return true;
            }
        }
        return false;
    }
}
