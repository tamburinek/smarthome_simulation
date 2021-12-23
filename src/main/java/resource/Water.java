package resource;

import enums.ResourceEnum;

public class Water extends Resource{
    public Water(ResourceEnum resource, int quantity) {
        super(ResourceEnum.WATER, quantity);
    }
}
