package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;


public class Main {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new Product("Молоко", 120);
        Product product2 = new Product("Хлеб", 80);
        Product product3 = new Product("Сыр", 340);
        Product product4 = new Product("Чай", 140);
        Product product5 = new Product("Шоколадка", 190);
        Product product6 = new Product("Винорад", 540);

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.addProduct(product6);

        productBasket.showBasket();
        productBasket.showBasketPrice();

        System.out.println(productBasket.checkProduct("Сыр") ? "Товар есть в корзине" : "Товара нету в корзине");

        productBasket.clearBasket();
        productBasket.showBasket();
        productBasket.showBasketPrice();

        System.out.println(productBasket.checkProduct("Сыр") ? "Товар есть в корзине" : "Товара нету в корзине");
    }
}