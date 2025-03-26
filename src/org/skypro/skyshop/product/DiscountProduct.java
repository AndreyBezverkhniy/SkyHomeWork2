package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private int price;
    private int discount;

    public DiscountProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return (int) (((double) price) * (100 - discount) / 100);
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + getDiscount() + ")";
    }
}
