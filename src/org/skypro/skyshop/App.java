package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("apple", 10));
        searchEngine.add(new FixPriceProduct("applicationFix"));
        searchEngine.add(new FixPriceProduct("fixApple"));
        searchEngine.add(new DiscountProduct("discountApple1", 400, 25));
        searchEngine.add(new DiscountProduct("discountapple2", 500, 35));
        searchEngine.add(new DiscountProduct("discountApple3", 600, 45));
        searchEngine.add(new Article("apleArticle1", "ap"));
        searchEngine.add(new Article("articleApple2", "app"));
        searchEngine.add(new Article("articleApple3", "ap"));
        searchEngine.add(new Article("appleArticle4", "ap"));
        String[] queries = {"app", "apple", "application"};
        for (String query : queries) {
            System.out.println(query);
            Searchable[] results = searchEngine.search(query);
            for (Searchable searchable : results) {
                if (searchable == null) {
                    break;
                }
                System.out.println(searchable.getStringRepresentation());
            }
            System.out.println();
        }
    }
}
