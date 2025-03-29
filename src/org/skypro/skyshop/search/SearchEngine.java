package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    public Set<Searchable> searchables = new HashSet<>();


    public Set<Searchable> search(String text) {
        if (text == null || text.isBlank()) {
            return null;
        }

        Set<Searchable> result = new TreeSet<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(text)) {
                result.add(searchable);
            }
        }
        return result;
    }

    public Searchable searchSuitable(String search) throws BestResultNotFound {
        Searchable s = null;
        int maxRepeatingCount = 0;

        for (Searchable searchable : searchables) {
            int curRepeatingCount = getRepeatingSubstringCount(searchable.getSearchTerm(), search);
            if (curRepeatingCount > maxRepeatingCount) {
                maxRepeatingCount = curRepeatingCount;
                s = searchable;
            }
        }

        if (s == null) {
            throw new BestResultNotFound("\"" + search + "\" не найден");
        }

        return s;
    }

    private int getRepeatingSubstringCount(String str, String substring) {
        int count = 0;
        int index = 0;
        int indexSubstring = str.indexOf(substring, index);
        while (indexSubstring != -1) {
            count++;
            index += substring.length();
            indexSubstring = str.indexOf(substring, index);
        }
        return count;
    }

    public void add(Searchable item) {
        searchables.add(item);
    }
}
