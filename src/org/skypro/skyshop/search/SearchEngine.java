package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;

    public SearchEngine(int size) {
        this.size = size;
        searchables = new Searchable[size];
    }

    public Searchable[] search(String text){
        if (text ==  null || text.isBlank()) {
            return null;
        }

        Searchable[] result = new Searchable[size];
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i].getSearchTerm().contains(text)) {
                result[i] = searchables[i];
            }
        }
        return result;
    }

    public Searchable searchSuitable(String search) throws BestResultNotFound{
        Searchable s = null;
        int maxRepeatingCount = 0;
        for (int i = 0; i < searchables.length; i++) {
            int curRepeatingCount = getRepeatingSubstringCount(searchables[i].getSearchTerm(), search);
            if (curRepeatingCount > maxRepeatingCount) {
                maxRepeatingCount = curRepeatingCount;
                s = searchables[i];
            }
        }

        if (s == null) {
            throw new BestResultNotFound("\"" + search + "\" не найден");
        }

        return s;
    }

    private int getRepeatingSubstringCount(String str, String substring){
        int count = 0;
        int index = 0;
        int indexSubstring = str.indexOf(substring, index);
        while(indexSubstring != -1){
            count++;
            index += substring.length();
            indexSubstring = str.indexOf(substring, index);
        }
        return count;
    }

    public void add(Searchable item){
        int index = nullPosition();
        if (index != -1) {
            searchables[index] = item;
        }else {
            System.out.println("Нет места");
        }
    }

    private int nullPosition(){
        int i = 0;
        for (; i < searchables.length; i++) {
            if (searchables[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
