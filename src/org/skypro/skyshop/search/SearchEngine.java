package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables = new LinkedList<>();


    public List<Searchable> search(String text) {
        if (text == null || text.isBlank()) {
            return null;
        }

        List<Searchable> result = new LinkedList<>();
        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i).getSearchTerm().contains(text)) {
                result.add(searchables.get(i));
            }
        }
        return result;
    }

    public Searchable searchSuitable(String search) throws BestResultNotFound {
        Searchable s = null;
        int maxRepeatingCount = 0;
        for (int i = 0; i < searchables.size(); i++) {
            int curRepeatingCount = getRepeatingSubstringCount(searchables.get(i).getSearchTerm(), search);
            if (curRepeatingCount > maxRepeatingCount) {
                maxRepeatingCount = curRepeatingCount;
                s = searchables.get(i);
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
