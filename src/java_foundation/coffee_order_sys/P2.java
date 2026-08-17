package java_foundation.coffee_order_sys;

import java.util.ArrayList;
import java.util.List;

public class P2 {

    public static void main(String[] args) {
        List<CoffeeOrder> orderList = new ArrayList<CoffeeOrder>();
        orderList.add(new CoffeeOrder("Jerry", CupSize.TALL));
        orderList.add(new CoffeeOrder("abcde", CupSize.VENTI));
        orderList.add(new CoffeeOrder("dffff", CupSize.GRANDE));

        orderList.forEach(
            order -> order.printCoffeeOrder()
        );
    }
}
