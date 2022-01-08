package enums;

public enum NeedsType {

    NEEDS_TO_EAT {
        @Override
        public String toString() {
            return "needs to eat";
        }
    },
    NEEDS_TO_SLEEP {
        @Override
        public String toString() {
            return "needs to sleep";
        }
    },
    NEED_TO_CLEAN {
        @Override
        public String toString() {
            return "needs to take a bath";
        }
    },
    NEEDS_TO_PLAY {
        @Override
        public String toString() {
            return "need to play";
        }
    };

    @Override
    public abstract String toString();
}
