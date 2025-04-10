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
                new SimpleProduct("app0apple0", 100),
                new SimpleProduct("app1apppp", 100),
                new SimpleProduct("app2apppp", 100),
                new SimpleProduct("app3apple1", 100),
                new SimpleProduct("app4apppp", 100),
                new SimpleProduct("app5apppp", 100),
                new SimpleProduct("app6apppp", 100),
                new SimpleProduct("app7apple2", 100),
                new SimpleProduct("app8apple3", 100),
                new SimpleProduct("app9apppp", 100),
        };
        for (Searchable searchable : searchablesToAdd) {
            searchEngine.add(searchable);
        }
        queries = new String[]{"none", "app", "apple"};
        for (String query : queries) {
            System.out.println("Search for \"" + query + "\"");
            List<Searchable> foundResults = searchEngine.search(query);
            if (foundResults.isEmpty()) {
                System.out.println("Результатов нет");
                continue;
            }
            for (Searchable foundResult : foundResults) {
                System.out.println("Найдено: " + foundResult);
            }
        }
    }
}
