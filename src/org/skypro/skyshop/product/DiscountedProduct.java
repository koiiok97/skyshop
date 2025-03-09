package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{

    private final int basePrice;
    private final int discountInPercent;

    public DiscountedProduct(String name, int basePrice, int discountInPercent) {
        super(name);
        if (basePrice < 0) {
            throw new IllegalArgumentException("цена должна быть строго больше 0");
        }
        if (discountInPercent <= 0 || discountInPercent >= 100) {
            throw new IllegalArgumentException("некорректная скидка");
        }
        this.basePrice = basePrice;
        this.discountInPercent = discountInPercent;
    }

    @Override
    public double getPrice() {
        return basePrice * (1 - discountInPercent / 100.0);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return name + " со скидкой : " + getPrice() + " скидка " + discountInPercent + "%";
    }
}
