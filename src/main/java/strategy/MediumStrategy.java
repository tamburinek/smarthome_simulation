package strategy;

import enums.Constants;
import enums.ResourceEnum;

public class MediumStrategy implements DifficultyStrategy{
    @Override
    public void setParams() {
        ResourceEnum.ELECTRICITY.setPrice(2);
        ResourceEnum.ELECTRICITY.add(10000);
        ResourceEnum.FOOD.setPrice(2);
        ResourceEnum.FOOD.add(10000);
        ResourceEnum.GAS.setPrice(2);
        ResourceEnum.GAS.add(10000);
        ResourceEnum.WATER.setPrice(2);
        ResourceEnum.WATER.add(10000);
        ResourceEnum.MONEY.add(10000);

        Constants.INDEX = 2;
        Constants.MAX_HUNGRY = 200;
        Constants.MAX_CLEAN = 200;
        Constants.MAX_HAPPINESS = 200;
        Constants.MAX_FRESH = 200;
    }

    @Override
    public String toString() {
        return "medium";
    }
}
