package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    public Product[] products = new Product[5];

    public void addProduct(Product product){
        int i = 0;
        for (; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                System.out.println("Добавлен продукт");
                break;
            }
        }
        if (i == products.length) {
            System.out.println("Нет свободного места");
        }
    }

    public void showBasketPrice(){
        int totalPrice = 0;
        for (Product product : products) {
            if (product == null) {
                break;
            }
            totalPrice += product.getPrice();
        }
        System.out.println("Общая стоимость корзины: " + totalPrice);
    }

    public void showBasket(){
        int totalProducts = 0;
        for (Product product : products) {
            if (product == null) {
                break;
            }
            totalProducts++;
            System.out.println(product);
        }
        if (totalProducts == 0){
            System.out.println("В корзине пусто");
            return;
        }
        showBasketPrice();
    }

    public  Boolean checkProduct(String name){
        for (Product product : products) {
            if (product != null && name.equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket(){
        Arrays.fill(products, null);
        System.out.println("Корзина очищена");
    }
}
