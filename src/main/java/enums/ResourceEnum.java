package enums;

public enum ResourceEnum {
    ELECTRICITY{
        private int price = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void changePrice(int price) {
            this.price = price;
        }

        @Override
        public String getName() {
            return "Electricity";
        }
    },

    FOOD{
        private int price = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void changePrice(int price) {
            this.price = price;
        }

        @Override
        public String getName() {
            return "Food";
        }
    },

    GAS{
        private int price = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void changePrice(int price) {
            this.price = price;
        }

        @Override
        public String getName() {
            return "Gas";
        }
    },

    MONEY{
        private int price = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void changePrice(int price) {
            this.price = price;
        }

        @Override
        public String getName() {
            return "Money";
        }
    },

    WATER{
        private int price = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void changePrice(int price) {
            this.price = price;
        }

        @Override
        public String getName() {
            return "Water";
        }
    };

    public abstract int price();
    public abstract void changePrice(int price);
    public abstract String getName();
}
