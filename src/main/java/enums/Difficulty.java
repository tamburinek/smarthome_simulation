package enums;

public enum Difficulty {

    EASY {
        @Override
        public void configure() {
            ResourceEnum.ELECTRICITY.setPrice(0);
            ResourceEnum.ELECTRICITY.add(0);
            ResourceEnum.FOOD.setPrice(0);
            ResourceEnum.FOOD.add(0);
            ResourceEnum.GAS.setPrice(0);
            ResourceEnum.GAS.add(0);
            ResourceEnum.WATER.setPrice(0);
            ResourceEnum.WATER.add(0);
            ResourceEnum.MONEY.add(0);
        }
    },
    MEDIUM {
        @Override
        public void configure() {
            ResourceEnum.ELECTRICITY.setPrice(0);
            ResourceEnum.ELECTRICITY.add(0);
            ResourceEnum.FOOD.setPrice(0);
            ResourceEnum.FOOD.add(0);
            ResourceEnum.GAS.setPrice(0);
            ResourceEnum.GAS.add(0);
            ResourceEnum.WATER.setPrice(0);
            ResourceEnum.WATER.add(0);
            ResourceEnum.MONEY.add(0);
        }
    },
    HARD {
        @Override
        public void configure() {
            ResourceEnum.ELECTRICITY.setPrice(0);
            ResourceEnum.ELECTRICITY.add(0);
            ResourceEnum.FOOD.setPrice(0);
            ResourceEnum.FOOD.add(0);
            ResourceEnum.GAS.setPrice(0);
            ResourceEnum.GAS.add(0);
            ResourceEnum.WATER.setPrice(0);
            ResourceEnum.WATER.add(0);
            ResourceEnum.MONEY.add(0);
        }
    };

    public abstract void configure();
}
