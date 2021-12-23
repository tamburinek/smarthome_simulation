import enums.ResourceEnum;

public class SecondRun {
    public static void main(String[] args) {

        ResourceEnum.MONEY.add(1000);
        System.out.println(ResourceEnum.MONEY.getQuantity());
        ResourceEnum.MONEY.consume(12);
        System.out.println(ResourceEnum.MONEY.getQuantity());

    }
}
