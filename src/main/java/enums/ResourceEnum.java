package enums;

public enum ResourceEnum {

    ELECTRICITY{
        private int price = 0;
        private int quantity = 0;
        private int consumedElectricity = 0;

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
            ResourceEnum.MONEY.consume(price * quantity);
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedElectricity += quantity;
            return quantity;
        }

        @Override
        public int consumedEnd() {
            return consumedElectricity;
        }

    },

    FOOD{
        private int price = 0;
        private int quantity = 0;
        private int consumedFood = 0;

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
            ResourceEnum.MONEY.consume(price * quantity);
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedFood += quantity;
            return quantity;
        }

        @Override
        public int consumedEnd() {
            return consumedFood;
        }

    },

    GAS{
        private int price = 0;
        private int quantity = 0;
        private int consumedGas = 0;

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
            ResourceEnum.MONEY.consume(price * quantity);
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedGas += quantity;
            return quantity;
        }

        @Override
        public int consumedEnd() {
            return consumedGas;
        }

    },

    MONEY{
        private int price = 1;
        private int quantity = 0;
        private int consumedMoney = 0;

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
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedMoney += quantity;
            return quantity;
        }

        @Override
        public int consumedEnd() {
            return consumedMoney;
        }
        },

    WATER{
        private int price = 0;
        private int quantity = 0;
        private int consumedWater = 0;

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
            ResourceEnum.MONEY.consume(price * quantity);
        }

        @Override
        public int consume(int quantity) {
            this.quantity -= quantity;
            consumedWater += quantity;
            return quantity;
        }

        @Override
        public int consumedEnd() {
            return consumedWater;
        }

    };

    public abstract int price();
    public abstract void setPrice(int price);
    public abstract String getName();
    public abstract int getQuantity();
    public abstract void add(int quantity);
    public abstract int consume(int quantity);
    public abstract int consumedEnd();
}
