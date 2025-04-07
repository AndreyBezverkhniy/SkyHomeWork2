package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
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

    private int getAppropriationIndex(Searchable searchable,String query){
        int appropriationIndex=0;
        int lastFoundPosition;
        String searchTerm=searchable.getSearchTerm();
        lastFoundPosition=searchTerm.indexOf(query,0);
        while(lastFoundPosition>=0){
            appropriationIndex++;
            lastFoundPosition=searchTerm.indexOf(query,lastFoundPosition+1);
        }
        return appropriationIndex;
    }

    public Searchable searchMostAppropriate(String query) throws BestResultNotFoundException {
        Searchable result=null;
        int resultAppropriationIndex=0;
        int appropriationIndex;
        for (Searchable searchable : searchables) {
            if (searchable == null) {
                break;
            }
            appropriationIndex=getAppropriationIndex(searchable,query);
            if (appropriationIndex == 0) {
                continue;
            }
            if (appropriationIndex > resultAppropriationIndex) {
                resultAppropriationIndex=appropriationIndex;
                result=searchable;
            }
        }
        if (result == null) {
            throw new BestResultNotFoundException();
        }
        return result;
    }

    public void add(Searchable searchable) {
        if (count >= searchables.length) {
            return;
        }
        searchables[count] = searchable;
        count++;
    }
}
