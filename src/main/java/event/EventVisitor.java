package event;

public class EventVisitor {

    public boolean visitBabyEvent(BabyEvent event){
        return false;
    }

    public boolean visitBasicEvent(BasicEvent event){
        return false;
    }

    public boolean visitRepairEvent(RepairEvent event){
        return false;
    }
}
