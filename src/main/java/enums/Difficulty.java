package enums;

public enum Difficulty {

    EASY {
        @Override
        public void configure() {
            ResourceEnum.ELECTRICITY.setPrice(0);
            ResourceEnum.ELECTRICITY.setQuantity(0);
            ResourceEnum.FOOD.setPrice(0);
            ResourceEnum.FOOD.setQuantity(0);
            ResourceEnum.GAS.setPrice(0);
            ResourceEnum.GAS.setQuantity(0);
            ResourceEnum.WATER.setPrice(0);
            ResourceEnum.WATER.setQuantity(0);
            ResourceEnum.MONEY.setQuantity(0);
        }
    },
    MEDIUM {
        @Override
        public void configure() {
            ResourceEnum.ELECTRICITY.setPrice(0);
            ResourceEnum.ELECTRICITY.setQuantity(0);
            ResourceEnum.FOOD.setPrice(0);
            ResourceEnum.FOOD.setQuantity(0);
            ResourceEnum.GAS.setPrice(0);
            ResourceEnum.GAS.setQuantity(0);
            ResourceEnum.WATER.setPrice(0);
            ResourceEnum.WATER.setQuantity(0);
            ResourceEnum.MONEY.setQuantity(0);
        }
    },
    HARD {
        @Override
        public void configure() {
            ResourceEnum.ELECTRICITY.setPrice(0);
            ResourceEnum.ELECTRICITY.setQuantity(0);
            ResourceEnum.FOOD.setPrice(0);
            ResourceEnum.FOOD.setQuantity(0);
            ResourceEnum.GAS.setPrice(0);
            ResourceEnum.GAS.setQuantity(0);
            ResourceEnum.WATER.setPrice(0);
            ResourceEnum.WATER.setQuantity(0);
            ResourceEnum.MONEY.setQuantity(0);
        }
    };

    public abstract void configure();
}
