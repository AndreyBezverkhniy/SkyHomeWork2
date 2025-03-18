package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(name).append(": ").append(cost);
        return sb.toString();
    }
}
