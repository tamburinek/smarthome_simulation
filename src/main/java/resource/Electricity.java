package resource;

import enums.ResourceEnum;

public class Electricity extends Resource{

    public Electricity(ResourceEnum resource, int quantity) {
        super(ResourceEnum.ELECTRICITY, quantity);
    }
}
