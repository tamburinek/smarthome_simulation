package resource;

import enums.ResourceEnum;

public class Food extends Resource{
    public Food(ResourceEnum resource, int quantity) {
        super(ResourceEnum.FOOD, quantity);
    }
}
