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
                .flatMap(Collection::stream)
                .map(product -> product.getPrice())
                .reduce(0, Integer::sum);
        return sum;
    }

    public long getSpecialCount() {
        long count = map.values().stream()
                .flatMap(Collection::stream)
                .filter(product -> product.isSpecial())
                .count();
        return count;
    }

    public void printBasket() {
        if (map.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        map.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("Итого: " + getBasketCost());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean hasProduct(String name) {
        return map.containsKey(name) && !map.get(name).isEmpty();
    }

    public void clear() {
        map.clear();
    }
}
