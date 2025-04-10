package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new LinkedList<Searchable>();
    }

    public List<Searchable> search(String query) {
        List<Searchable> result = new LinkedList<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                result.add(searchable);
            }
        }
        return result;
    }

    private int getAppropriationIndex(Searchable searchable, String query) {
        int appropriationIndex = 0;
        int lastFoundPosition;
        String searchTerm = searchable.getSearchTerm();
        lastFoundPosition = searchTerm.indexOf(query, 0);
        while (lastFoundPosition >= 0) {
            appropriationIndex++;
            lastFoundPosition = searchTerm.indexOf(query, lastFoundPosition + 1);
        }
        return appropriationIndex;
    }

    public Searchable searchMostAppropriate(String query) throws BestResultNotFoundException {
        Searchable result = null;
        int resultAppropriationIndex = 0;
        int appropriationIndex;
        for (Searchable searchable : searchables) {
            if (searchable == null) {
                break;
            }
            appropriationIndex = getAppropriationIndex(searchable, query);
            if (appropriationIndex == 0) {
                continue;
            }
            if (appropriationIndex > resultAppropriationIndex) {
                resultAppropriationIndex = appropriationIndex;
                result = searchable;
            }
        }
        if (result == null) {
            throw new BestResultNotFoundException();
        }
        return result;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }
}
