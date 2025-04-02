package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;

public class App {
    public static void main(String[] args) {
        System.out.println("Product::name");
        try {
            System.out.println("name=null");
            Product product = new SimpleProduct(null, 100);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        try {
            System.out.println("name=\"\"");
            Product product = new SimpleProduct("", 100);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        try {
            System.out.println("name=blank");
            Product product = new SimpleProduct("  ", 100);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        System.out.println("SimpleProduct::price");
        try {
            System.out.println("price=0");
            Product product = new SimpleProduct("12", 0);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        System.out.println("SimpleProduct::success");
        try {
            int price=100;
            String name="product";
            System.out.println("name="+name+" price="+price);
            Product product = new SimpleProduct(name, price);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        System.out.println("DiscountProduct::price");
        try {
            int price=0;
            int discount=50;
            String name="product";
            System.out.println("name="+name+" price="+price+" discount="+discount);
            Product product = new DiscountProduct(name, price, discount);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        System.out.println("DiscountProduct::discount");
        try {
            int price=100;
            int discount=-1;
            String name="product";
            System.out.println("name="+name+" price="+price+" discount="+discount);
            Product product = new DiscountProduct(name, price, discount);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        try {
            int price=100;
            int discount=101;
            String name="product";
            System.out.println("name="+name+" price="+price+" discount="+discount);
            Product product = new DiscountProduct(name, price, discount);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        System.out.println("DiscountProduct::success");
        try {
            int price=100;
            int discount=0;
            String name="product";
            System.out.println("name="+name+" price="+price+" discount="+discount);
            Product product = new DiscountProduct(name, price, discount);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        try {
            int price=100;
            int discount=50;
            String name="product";
            System.out.println("name="+name+" price="+price+" discount="+discount);
            Product product = new DiscountProduct(name, price, discount);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        try {
            int price=100;
            int discount=100;
            String name="product";
            System.out.println("name="+name+" price="+price+" discount="+discount);
            Product product = new DiscountProduct(name, price, discount);
            System.out.println("success");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
        System.out.println("SearchEngine");
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("1app", 10));
        searchEngine.add(new SimpleProduct("2appapp", 10));
        searchEngine.add(new SimpleProduct("3appapp", 10));
        searchEngine.add(new SimpleProduct("4appleappapp", 10));
        searchEngine.add(new SimpleProduct("5appleapple", 10));
        searchEngine.add(new SimpleProduct("6appleapple", 10));
        searchEngine.add(new SimpleProduct("7apple", 10));
        String[] queries = {"app", "apple", "computer"};
        for (String query : queries) {
            System.out.println("query="+query);
            Searchable result;
            try {
                result = searchEngine.searchMostAppropriate(query);
                System.out.println("result="+result.getStringRepresentation());
            } catch (BestResultNotFoundException e) {
                System.out.println("BestResultNotFoundException");
            }
        }
    }
}
