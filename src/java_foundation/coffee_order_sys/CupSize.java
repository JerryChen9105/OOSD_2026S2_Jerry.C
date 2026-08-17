package java_foundation.coffee_order_sys;

public enum CupSize {
    TALL(25), GRANDE(30), VENTI(35);

    int price;

    CupSize(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

}
