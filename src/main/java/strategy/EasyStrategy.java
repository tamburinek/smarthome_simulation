package strategy;

import enums.Constants;
import enums.ResourceEnum;

public class EasyStrategy implements DifficultyStrategy{

    @Override
    public void setParams() {
        ResourceEnum.ELECTRICITY.setPrice(1000);
        ResourceEnum.ELECTRICITY.add(1000);
        ResourceEnum.FOOD.setPrice(1000);
        ResourceEnum.FOOD.add(1000);
        ResourceEnum.GAS.setPrice(1000);
        ResourceEnum.GAS.add(1000);
        ResourceEnum.WATER.setPrice(1000);
        ResourceEnum.WATER.add(1000);
        ResourceEnum.MONEY.add(10001000);
        Constants.MAX_HEALTH = 1000;
        Constants.MAX_CLEAN = 1000;
        Constants.MAX_HAPPINESS = 1000;
    }
}
