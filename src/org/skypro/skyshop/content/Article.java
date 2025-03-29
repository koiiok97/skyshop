package org.skypro.skyshop.content;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Название: " + title + "\nТекст: " + text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o != null || getClass() != o.getClass()) return false;
        return Objects.equals(title, ((Article) o).title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public int compareTo(Object o) {
        int comp = Integer.compare(((Article) o).getSearchTerm().length(), title.length());
        return comp != 0 ? comp : title.compareTo(((Product) o).getSearchTerm());
    }
}
