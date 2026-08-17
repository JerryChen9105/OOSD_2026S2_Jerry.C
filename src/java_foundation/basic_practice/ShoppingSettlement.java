package java_foundation.basic_practice;

public class ShoppingSettlement {

    public static void main(String[] args) {
        float goodPrice = 49.9f;
        int consumeNum = 3;
        boolean isVIP = true;

        boolean includeDelivery = false;
        float finalPayment = goodPrice * consumeNum;
        includeDelivery = (isVIP && finalPayment >= 100);

        System.out.printf("total payment: %.2f\n", finalPayment);
        System.out.println("include delivery: " + includeDelivery);

    }

}

