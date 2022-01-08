package event;

public interface Visitor {

    boolean visitBabyEvent(BabyEvent event);

    boolean visitBasicEvent(BasicEvent event);

    boolean visitRepairEvent(RepairEvent event);
}
