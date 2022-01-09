package enums;

public enum NotificationType {

    STARTED_USING {
        @Override
        public String toString() {
            return "started using";
        }
    },
    ENDED_USING {
        @Override
        public String toString() {
            return "ended using";
        }
    },
    STARTED_REPAIRING {
        @Override
        public String toString() {
            return "started repairing";
        }
    },
    BROKE {
        @Override
        public String toString() {
            return "broke";
        }
    },
    ENDED_REPAIRING {
        @Override
        public String toString() {
            return "ended repairing";
        }
    },
    CALLED_REPAIRMAN {
        @Override
        public String toString() {
            return "called repairman";
        }
    },
    DIED {
        @Override
        public String toString() {
            return "died";
        }
    };

    @Override
    public abstract String toString();
}
