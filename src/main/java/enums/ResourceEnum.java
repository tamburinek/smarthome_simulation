package enums;

public enum ResourceEnum {

    ELECTRICITY{
        private int price = 0;
        private int quantity = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String getName() {
            return "Electricity";
        }

        @Override
        public int getQuantity() {
            return quantity;
        }

        @Override
        public void add(int quantity) {
            this.quantity += quantity;
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedElectricity += quantity;
            return quantity;
        }

    },

    FOOD{
        private int price = 0;
        private int quantity = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String getName() {
            return "Food";
        }

        @Override
        public int getQuantity() {
            return quantity;
        }

        @Override
        public void add(int quantity) {
            this.quantity += quantity;
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedFood += quantity;
            return quantity;
        }

    },

    GAS{
        private int price = 0;
        private int quantity = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String getName() {
            return "Gas";
        }

        @Override
        public int getQuantity() {
            return quantity;
        }

        @Override
        public void add(int quantity) {
            this.quantity += quantity;
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedGas += quantity;
            return quantity;
        }

    },

    MONEY{
        private int price = 1;
        private int quantity = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void setPrice(int price) {
            System.out.println("you cant change price of money");
        }

        @Override
        public String getName() {
            return "Money";
        }

        @Override
        public int getQuantity() {
            return quantity;
        }

        @Override
        public void add(int quantity) {
            this.quantity += quantity;
            earnedMoney += quantity;
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedMoney += quantity;
            return quantity;
        }

    },

    WATER{
        private int price = 0;
        private int quantity = 0;

        @Override
        public int price() {
            return price;
        }

        @Override
        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String getName() {
            return "Water";
        }

        @Override
        public int getQuantity() {
            return quantity;
        }

        @Override
        public void add(int quantity) {
            this.quantity += quantity;
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedWater += quantity;
            return quantity;
        }

    };

    public abstract int price();
    public abstract void setPrice(int price);
    public abstract String getName();
    public abstract int getQuantity();
    public abstract void add(int quantity);
    public abstract int consume(int quantity);

    public int consumedElectricity = 0;
    public int consumedFood = 0;
    public int consumedGas = 0;
    public int consumedMoney = 0;
    public int earnedMoney = 0;
    public int consumedWater = 0;

}
