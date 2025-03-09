package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Пустое наименование");
        }
        this.name = name;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }

    @Override
    public String getSearchTerm(){
        return getName();
    }

    @Override
    public String getContentType(){
        return "PRODUCT";
    }
}
