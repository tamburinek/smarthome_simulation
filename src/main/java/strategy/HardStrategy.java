package strategy;

import enums.Constants;
import enums.ResourceEnum;

public class HardStrategy implements DifficultyStrategy{
    @Override
    public void setParams() {
        ResourceEnum.ELECTRICITY.setPrice(3);
        ResourceEnum.ELECTRICITY.add(1000);
        ResourceEnum.FOOD.setPrice(3);
        ResourceEnum.FOOD.add(1000);
        ResourceEnum.GAS.setPrice(3);
        ResourceEnum.GAS.add(1000);
        ResourceEnum.WATER.setPrice(3);
        ResourceEnum.WATER.add(1000);
        ResourceEnum.MONEY.add(1000);

        Constants.INDEX = 3;
        Constants.MAX_HUNGRY = 100;
        Constants.MAX_CLEAN = 100;
        Constants.MAX_HAPPINESS = 100;
        Constants.MAX_FRESH = 100;
    }

    @Override
    public String toString() {
        return "hard";
    }

}
