package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("Молоко", 120);
        Product product2 = new DiscountedProduct("Хлеб", 100, 20);
        Product product3 = new FixPriceProduct("Сыр");
        Product product4 = new DiscountedProduct("Чай", 139, 55);
        Product product5 = new DiscountedProduct("Шоколадка", 190, 19);
        Product product6 = new FixPriceProduct("Винорад");

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.addProduct(product6);

        productBasket.showBasket();
        productBasket.specialProduct();
        productBasket.showBasketPrice();

        System.out.println(productBasket.checkProduct("Сыр") ? "Товар есть в корзине" : "Товара нету в корзине");

        productBasket.clearBasket();
        productBasket.showBasket();
        productBasket.showBasketPrice();

        System.out.println(productBasket.checkProduct("Сыр") ? "Товар есть в корзине" : "Товара нету в корзине");

        SearchEngine search = new SearchEngine(7);
        search.add(product1);
        search.add(product2);
        search.add(product3);
        search.add(product4);
        search.add(product5);

        Article article1 = new Article("article1", "text1 text1 text1");
        Article article2 = new Article("article2", "text2 text2 text2");

        search.add(article1);
        search.add(article2);

        System.out.println(Arrays.toString(search.search("text")));


    }
}