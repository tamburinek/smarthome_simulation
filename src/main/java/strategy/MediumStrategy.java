package strategy;

import enums.ResourceEnum;

public class MediumStrategy implements DifficultyStrategy{
    @Override
    public void setParams() {
        ResourceEnum.ELECTRICITY.setPrice(10);
        ResourceEnum.ELECTRICITY.add(10);
        ResourceEnum.FOOD.setPrice(10);
        ResourceEnum.FOOD.add(10);
        ResourceEnum.GAS.setPrice(10);
        ResourceEnum.GAS.add(10);
        ResourceEnum.WATER.setPrice(10);
        ResourceEnum.WATER.add(10);
        ResourceEnum.MONEY.add(10);
    }

    @Override
    public String toString() {
        return "medium";
    }
}
