package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ProductBasket {
    private List<Product> list;

    public ProductBasket() {
        list = new LinkedList<>();
    }

    public void add(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("product null value forbidden");
        }
        list.add(product);
    }

    public List<Product> remove(String name) {
        List<Product> removedProducts = new LinkedList<>();
        ListIterator<Product> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public int getBasketCost() {
        int sum = 0;
        for (Product products : list) {
            sum += products.getPrice();
        }
        return sum;
    }

    public void printBasket() {
        boolean empty = true;
        int sum = 0;
        int specProductAmount = 0;
        for (Product product : list) {
            if (product.isSpecial()) {
                specProductAmount++;
            }
            empty = false;
            System.out.println(product);
            sum += product.getPrice();
        }
        if (empty) {
            System.out.println("в корзине пусто");
            return;
        }
        System.out.println("Итого: " + sum);
        System.out.println("Специальных товаров: " + specProductAmount);
    }

    public boolean hasProduct(String name) {
        for (Product product : list) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        list.clear();
    }
}
