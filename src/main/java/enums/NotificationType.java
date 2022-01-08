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
    HAVE_HUNGER {
        @Override
        public String toString() {
            return "has hunger";
        }
    },
    IS_DIRTY {
        @Override
        public String toString() {
            return "is dirty";
        }
    },
    NEEDS_SLEEP {
        @Override
        public String toString() {
            return "needs to sleep";
        }
    },
    IS_NOT_HAPPY {
        @Override
        public String toString() {
            return "is not happy";
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
