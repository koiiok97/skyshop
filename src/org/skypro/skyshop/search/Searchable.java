package org.skypro.skyshop.search;

public interface Searchable extends Comparable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return "имя " + getSearchTerm() + " - объекта — тип " + getContentType() + " - объекта";
    }


    @Override
    int compareTo(Object o);
}
