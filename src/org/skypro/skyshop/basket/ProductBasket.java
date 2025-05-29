package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> map;

    public ProductBasket() {
        map = new HashMap<>();
    }

    public void add(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("product null value forbidden");
        }
        map.computeIfAbsent(product.getName(), (k) -> (new LinkedList<Product>())).add(product);
    }

    public List<Product> remove(String name) {
        List<Product> removedProducts = new LinkedList<>();
        removedProducts = map.getOrDefault(name, new LinkedList<Product>());
        map.remove(name);
        return removedProducts;
    }

    public int getBasketCost() {
        int sum = map.values().stream()
                .flatMap(list -> list.stream())
                .map(product -> product.getPrice())
                .reduce(0, Integer::sum);
        return sum;
    }

    public void printBasket() {
        boolean empty = true;
        int sum = 0;
        int specProductAmount = 0;
        for (List<Product> productList : map.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    specProductAmount++;
                }
                empty = false;
                System.out.println(product);
                sum += product.getPrice();
            }
        }
        if (empty) {
            System.out.println("в корзине пусто");
            return;
        }
        System.out.println("Итого: " + sum);
        System.out.println("Специальных товаров: " + specProductAmount);
    }

    public boolean hasProduct(String name) {
        return map.containsKey(name) && !map.get(name).isEmpty();
    }

    public void clear() {
        map.clear();
    }
}
