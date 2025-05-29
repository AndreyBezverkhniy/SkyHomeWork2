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

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        Searchable[] searchablesToAdd = {
                new Article("Dapple_double", "Text"),
                new Article("Dapple_double", "Text"),
                new Article("length_1", "Text"),
                new Article("length_333", "Text"),
                new Article("length_22", "Text"),
                new Article("length_4444", "Text"),
                new Article("length_long_alphabet_abc", "Text"),
                new Article("length_long_alphabet_acc", "Text"),
                new Article("length_long_alphabet_aac", "Text"),
        };
        for (Searchable searchable : searchablesToAdd) {
            searchEngine.add(searchable);
        }
        String[] queries = new String[]{"abc", "long", ""};
        for (String query : queries) {
            System.out.println("Search for \"" + query + "\"");
            Set<Searchable> foundResults = searchEngine.search(query);
            if (foundResults.isEmpty()) {
                System.out.println("Результатов нет");
                continue;
            }
            for (Searchable foundResult : foundResults) {
                System.out.println("Найдено: " + foundResult.getSearchableName());
            }
        }
        System.out.println();
        ProductBasket basket = new ProductBasket();
        basket.add(new DiscountProduct("discount", 100, 20));
        basket.add(new FixPriceProduct("fix"));
        basket.add(new SimpleProduct("simple", 300));
        basket.printBasket();
    }
}
