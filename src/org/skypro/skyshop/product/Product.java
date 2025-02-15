package org.skypro.skyshop.product;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Пустое наименование");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Некорректная цена");
        }
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : "+ price;
    }
}
