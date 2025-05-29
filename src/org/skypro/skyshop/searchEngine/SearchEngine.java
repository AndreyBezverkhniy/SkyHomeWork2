package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.interfaces.Searchable;

import javax.naming.directory.SearchControls;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SearchEngine {
    private Set<Searchable> searchables;


    public SearchEngine() {
        this.searchables = new HashSet<Searchable>();
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> result = new TreeSet<Searchable>(
                new Comparator<Searchable>() {
                    @Override
                    public int compare(Searchable o1, Searchable o2) {
                        String name1 = o1.getSearchableName();
                        String name2 = o2.getSearchableName();
                        int lengthCompare = Integer.compare(name2.length(), name1.length());
                        if (lengthCompare != 0) {
                            return lengthCompare;
                        }
                        return name1.compareTo(name2);
                    }
                }
        );
        Stream<Searchable> stream=searchables.stream();
        //stream.filter(getSearchTerm().contains(query));
        Function<Searchable,String> getTermFunc=Searchable::getSearchTerm;
        Predicate<String> containsPredicate=String::contains();
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
