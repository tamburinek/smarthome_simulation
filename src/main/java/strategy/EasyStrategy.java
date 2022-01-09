package strategy;

import enums.Constants;
import enums.ResourceEnum;

public class EasyStrategy implements DifficultyStrategy{

    @Override
    public void setParams() {
        ResourceEnum.ELECTRICITY.setPrice(1);
        ResourceEnum.ELECTRICITY.add(100000);
        ResourceEnum.FOOD.setPrice(1);
        ResourceEnum.FOOD.add(100000);
        ResourceEnum.GAS.setPrice(1);
        ResourceEnum.GAS.add(100000);
        ResourceEnum.WATER.setPrice(1);
        ResourceEnum.WATER.add(100000);
        ResourceEnum.MONEY.add(10000000);

        Constants.INDEX = 1;
        Constants.MAX_HUNGRY = 300;
        Constants.MAX_CLEAN = 300;
        Constants.MAX_HAPPINESS = 300;
        Constants.MAX_FRESH = 300;
    }

    @Override
    public String toString() {
        return "easy";
    }
}
