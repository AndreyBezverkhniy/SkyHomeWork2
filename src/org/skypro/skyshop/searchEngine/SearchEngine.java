package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.interfaces.Searchable;

public class SearchEngine {
    private Searchable[] searchables;
    private int count;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
        this.count = 0;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int index = 0;
        for (Searchable searchable : searchables) {
            if (searchable == null || index >= 5) {
                break;
            }
            if (searchable.getSearchTerm().contains(query)) {
                results[index] = searchable;
                index++;
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        if (count >= searchables.length) {
            return;
        }
        searchables[count] = searchable;
        count++;
    }
}
