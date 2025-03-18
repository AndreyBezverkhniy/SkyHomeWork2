package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.add(new SimpleProduct("apple", 10));
        basket.add(new FixPriceProduct("fixApple1"));
        basket.add(new FixPriceProduct("fixApple2"));
        basket.add(new DiscountProduct("discountApple1", 400, 25));
        basket.add(new DiscountProduct("discountApple2", 500, 35));
        basket.add(new DiscountProduct("discountApple3", 600, 45));
        basket.printBasket();
    }
}
