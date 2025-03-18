package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] arr;

    public ProductBasket() {
        arr = new Product[5];
    }

    public void add(Product product) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                continue;
            }
            arr[i] = product;
            return;
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getBasketCost() {
        int sum = 0;
        for (Product products : arr) {
            if (products == null) {
                continue;
            }
            sum += products.getCost();
        }
        return sum;
    }

    public void printBasket() {
        boolean empty = true;
        int sum = 0;
        for (Product product : arr) {
            if (product == null) {
                continue;
            }
            empty = false;
            System.out.println(product);
            sum += product.getCost();
        }
        if (empty) {
            System.out.println("в корзине пусто");
            return;
        }
        System.out.println("Итого: " + sum);
    }

    public boolean hasProduct(String name) {
        for (Product product : arr) {
            if (product == null) {
                continue;
            }
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(arr, null);
    }
}
