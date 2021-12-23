package resource;

import enums.ResourceEnum;

public class Gas extends Resource{
    public Gas(ResourceEnum resource, int quantity) {
        super(ResourceEnum.GAS, quantity);
    }
}
