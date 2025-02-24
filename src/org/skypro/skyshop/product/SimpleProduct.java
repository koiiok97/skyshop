package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private final int price;
    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }


    @Override
    public String toString() {
        return name + " : " + price;
    }
}
