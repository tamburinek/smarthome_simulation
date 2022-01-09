package strategy;

import enums.ResourceEnum;

public class HardStrategy implements DifficultyStrategy{
    @Override
    public void setParams() {
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

    @Override
    public String toString() {
        return "hard";
    }

}
