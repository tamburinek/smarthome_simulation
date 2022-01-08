package event;

import java.util.Random;

public class EventVisitor {

    public boolean visitBabyEvent(BabyEvent event){
        if (Event.activitiesToDo.contains(event)) {
            if (event.getHuman().isIn(event.getBaby().getLocation())) {
                if (!event.getHuman().isDoingSt() && !event.getBaby().isDoingSt()) {
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
                event.getHuman().setDoingSt(false);
                event.getBaby().setDoingSt(false);
                return true;
            }
        }
        return false;
    }

    public boolean visitBasicEvent(BasicEvent event){
        if (Event.activitiesToDo.contains(event)) {
            if (event.getHuman().isIn(event.getUsingDevice().getLocation())) {
                if (!event.getUsingDevice().getState().isOccupied() && !event.getUsingDevice().getState().isBroken()) {
                    event.getUsingDevice().useDevice(event.getHuman());

                    System.out.println("Human: " + event.getHuman().getName() + " started using device: " + event.getUsingDevice().getDeviceName() + " and will be doing for " + event.getDuration());

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
                System.out.println("Human: " + event.getHuman().getName() + " ended using device: " + event.getUsingDevice().getDeviceName());
                event.getHuman().printStats();
                return true;
            }
        }
        return false;
    }

    public boolean visitRepairEvent(RepairEvent event){
        if (Event.activitiesToDo.contains(event)) {
            if (event.getHuman().isIn(event.getUsingDevice().getLocation())) {
                if (!event.getHuman().isDoingSt() && !event.getUsingDevice().getState().isOccupied() && event.getUsingDevice().getState().isBroken()) {
                    if (event.getSolution() == 0) {
                        Random r = new Random();
                        int res = r.nextInt(70);
                        if (res < event.getHuman().getAge()) {
                            // human will repair device himself
                            event.setSolution(1);
                        } else if (event.getUsingDevice().getRepairDifficulty() % 2 == 0) {
                            // human will hire a repairman
                            event.setSolution(2);
                            event.setDuration(Math.abs(event.getDuration() - event.getUsingDevice().getRepairDifficulty()));
                        } else {
                            // human will buy new device
                            event.setSolution(3);
                            event.setDuration(Math.abs(event.getDuration() - event.getUsingDevice().getRepairDifficulty()));
                        }

                    }
                    event.getUsingDevice().useDevice(event.getHuman());
                    Event.activitiesToDo.remove(event);
                    Event.currentActivities.add(event);
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
                Event.currentActivities.remove(event);
                if(event.getSolution() == 1) {
                    event.getUsingDevice().repairDevice(event.getHuman());
                }
                if(event.getSolution() == 2) {
                    event.getUsingDevice().callRepairman(event.getHuman());
                }
                if(event.getSolution() == 3) {
                    event.getUsingDevice().buyNewDevice(event.getHuman());
                }
                event.getUsingDevice().stopUsingDevice(event.getHuman());
                event.getHuman().claimSatisfy(event.getUsingDevice());
            }
            return true;
        }
        return false;
    }

    public boolean animalEvent(AnimalEvent event){
        if (Event.activitiesToDo.contains(event)) {
            if (event.getHuman().isIn(event.getAnimal().getLocation())) {
                if (!event.getHuman().isDoingSt() && !event.getAnimal().isDoingSt()) {
                    event.getAnimal().setDoingSt(true);
                    event.getHuman().setDoingSt(true);
                    Event.activitiesToDo.remove(event);
                    Event.currentActivities.add(event);
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
            }
            return true;
        }
        return false;
    }
}
