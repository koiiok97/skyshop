package org.skypro.skyshop.search;

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
