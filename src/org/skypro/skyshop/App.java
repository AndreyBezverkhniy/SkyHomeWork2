package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product product = new Product("apple", 10);
        basket.add(product);
        System.out.println("Basket::");
        basket.printBasket();
        for (int i = 0; i < 6; i++) {
            basket.add(new Product("apple#" + i, 20 + i));
        }
        System.out.println("Basket::");
        basket.printBasket();
        System.out.println("basket.getBasketCost() = " + basket.getBasketCost());
        System.out.println("basket.hasProduct(\"apple#2\") = " + basket.hasProduct("apple#2"));
        System.out.println("basket.hasProduct(\"apple#5\") = " + basket.hasProduct("apple#5"));
        basket.clear();
        System.out.println("Basket::");
        basket.printBasket();
        System.out.println("basket.getBasketCost() = " + basket.getBasketCost());
        System.out.println("basket.hasProduct(\"apple#2\") = " + basket.hasProduct("apple#2"));
    }
}
