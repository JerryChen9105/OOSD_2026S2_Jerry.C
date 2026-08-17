package java_foundation.coffee_order_sys;

public class CoffeeOrder {
    String customerName;
    CupSize size;

    public CoffeeOrder(String name, CupSize size) {
        this.customerName = name;
        this.size = size;
    }

    public void printCoffeeOrder() {
        System.out.println("customer : " + this.customerName);
        System.out.println("ordered cupsize : " + this.size);
        System.out.println("price : " + this.size.getPrice() + "\n");
    }

}
