package enums;

/**
 * different types of notification
 */
public enum NotificationType {

    STARTED_USING {
        @Override
        public String toString() {
            return "started using";
        }
    },
    STARTED_USING_ANIMAL {
        @Override
        public String toString() {
            return "animal started using";
        }
    },
    ENDED_USING {
        @Override
        public String toString() {
            return "ended using";
        }
    },

    ENDED_USING_ANIMAL {
        @Override
        public String toString() {
            return "animal ended using";
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
    BROKE_IN_IDLE {
        @Override
        public String toString() {
            return "broke on its own";
        }
    };

    @Override
    public abstract String toString();
}
