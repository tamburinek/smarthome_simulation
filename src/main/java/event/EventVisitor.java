package event;

import manuals.Manual;

public class EventVisitor {

    public boolean visitBabyEvent(BabyEvent event){
        if (Event.eventsToDo.contains(event)) {
            if (event.getHuman().isIn(event.getBaby().getLocation())) {
                if (!event.getHuman().isDoingSt() && !event.getBaby().isDoingSt()) {
                    event.getBaby().setDoingSt(true);
                    event.getHuman().setDoingSt(true);
                    Event.eventsToDo.remove(event);
                    Event.currentEvents.add(event);
                } else
                    return false;
            } else {
                event.getHuman().setLocation(event.getBaby().getLocation());
                return false;
            }
        }
        if (Event.currentEvents.contains(event)) {
            event.setDuration(event.getDuration() - 10);
            if (event.getDuration() <= 0) {
                Event.currentEvents.remove(event);
                event.getHuman().setDoingSt(false);
                event.getBaby().setDoingSt(false);
            }
            return true;
        }
        return false;
    }

    public boolean visitBasicEvent(BasicEvent event){
        if (Event.eventsToDo.contains(event)) {
            if (event.getHuman().isIn(event.getUsingDevice().getLocation())) {
                if (!event.getHuman().isDoingSt() && !event.getUsingDevice().getState().isOccupied() && !event.getUsingDevice().getState().isBroken()) {
                    event.getUsingDevice().useDevice(event.getHuman());
                    Event.eventsToDo.remove(event);
                    Event.currentEvents.add(event);
                } else
                    return false;
            } else {
                event.getHuman().setLocation(event.getUsingDevice().getLocation());
                return false;
            }
        }
        if (Event.currentEvents.contains(event)) {
            event.setDuration(event.getDuration() - 10);
            if (event.getDuration() <= 0) {
                Event.currentEvents.remove(event);
                event.getUsingDevice().stopUsingDevice(event.getHuman());
            }
            return true;
        }
        return false;
    }

    public boolean visitRepairEvent(RepairEvent event){
        if (Event.eventsToDo.contains(event)) {
            if (event.getHuman().isIn(event.getUsingDevice().getLocation())) {
                if (!event.getHuman().isDoingSt() && !event.getUsingDevice().getState().isOccupied() && event.getUsingDevice().getState().isBroken()) {
                    event.getUsingDevice().useDevice(event.getHuman());
                    Event.eventsToDo.remove(event);
                    Event.currentEvents.add(event);
                } else
                    return false;
            } else {
                event.getHuman().setLocation(event.getUsingDevice().getLocation());
                return false;
            }
        }
        //TODO
        if (Event.currentEvents.contains(event)) {
            event.setDuration(event.getDuration() - 10);
            if (event.getDuration() <= 0) {
                Event.currentEvents.remove(event);
                event.getUsingDevice().stopUsingDevice(event.getHuman());
            }
            return true;
        }
        return false;
    }
}
