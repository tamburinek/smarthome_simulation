package resource;

import enums.ResourceEnum;

public abstract class Resource {

    private ResourceEnum resourceType;
    private int quantity;
    private final String name;

    public Resource(ResourceEnum resource){
        resourceType = resource;
        this.quantity = resource.getQuantity();
        this.name = resource.getName();
    }

    public ResourceEnum getResourceType() {
        resourceType.price();
        return resourceType;
    }

    public String getName() {
        return name;
    }
}
