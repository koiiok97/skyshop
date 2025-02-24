package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int FIX_PRICE = 100;
    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return name + " с фиксированной ценой : Фиксированная цена " + FIX_PRICE;
    }
}
