package strategy;

import enums.Constants;
import enums.ResourceEnum;

public class EasyStrategy implements DifficultyStrategy{

    @Override
    public void setParams() {
        ResourceEnum.ELECTRICITY.setPrice(1);
        ResourceEnum.ELECTRICITY.add(1000);
        ResourceEnum.FOOD.setPrice(1);
        ResourceEnum.FOOD.add(1000);
        ResourceEnum.GAS.setPrice(1);
        ResourceEnum.GAS.add(1000);
        ResourceEnum.WATER.setPrice(1);
        ResourceEnum.WATER.add(1000);
        ResourceEnum.MONEY.add(0);

        Constants.INDEX = 1;
        Constants.MAX_HUNGRY = 100;
        Constants.MAX_CLEAN = 100;
        Constants.MAX_HAPPINESS = 100;
        Constants.MAX_FRESH = 100;
    }

    @Override
    public String toString() {
        return "easy";
    }
}
