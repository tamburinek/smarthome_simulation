package resource;

import enums.ResourceEnum;

public class Money extends Resource{
    public Money(ResourceEnum resource, int quantity) {
        super(ResourceEnum.MONEY, quantity);
    }
}
