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

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.add(new SimpleProduct("hotcat1", 100));
        productBasket.add(new SimpleProduct("hotcat2", 200));
        productBasket.add(new SimpleProduct("hotcat1", 300));
        productBasket.add(new SimpleProduct("hotcat2", 400));
        productBasket.add(new SimpleProduct("hotcat1", 500));
        productBasket.add(new SimpleProduct("hotcat2", 600));
        productBasket.printBasket();
        List<Product> removedProducts;
        String[] queries = {"", "hotcat1"};
        for (String query : queries) {
            System.out.println("Удаляем \"" + query + "\"");
            removedProducts = productBasket.remove(query);
            System.out.println("Остались");
            productBasket.printBasket();
            if (removedProducts.isEmpty()) {
                System.out.println("Ничего не удалено");
                continue;
            }
            for (Product removedProduct : removedProducts) {
                System.out.println("Удалён " + removedProduct);
            }
        }
        SearchEngine searchEngine = new SearchEngine();
        Searchable[] searchablesToAdd = {
                new SimpleProduct("0_app0apple0", 101),
                new SimpleProduct("2_app1apppp", 102),
                new SimpleProduct("7_app2apppp", 103),
                new SimpleProduct("8_app3apple1", 104),
                new SimpleProduct("5_app4apppp", 105),
                new SimpleProduct("3_app5apppp", 106),
                new SimpleProduct("9_app6apppp", 107),
                new SimpleProduct("6_app7apple2", 108),
                new SimpleProduct("4_app8apple3", 109),
                new SimpleProduct("1_app9apppp", 110),
        };
        for (Searchable searchable : searchablesToAdd) {
            searchEngine.add(searchable);
        }
        queries = new String[]{"none", "app", "apple"};
        for (String query : queries) {
            System.out.println("Search for \"" + query + "\"");
            Map<String, Searchable> foundResults = searchEngine.search(query);
            if (foundResults.isEmpty()) {
                System.out.println("Результатов нет");
                continue;
            }
            for (Map.Entry<String, Searchable> foundResult : foundResults.entrySet()) {
                System.out.println("Найдено: " + foundResult.getKey() + " = " + foundResult.getValue());
            }
        }
    }
}
