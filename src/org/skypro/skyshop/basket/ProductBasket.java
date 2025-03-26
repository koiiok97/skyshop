package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    public Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), _ -> new ArrayList<>()).add(product);
        System.out.println("Добавлен продукт");
    }

    public void showBasketPrice() {
        int totalPrice = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product == null) {
                    break;
                }
                totalPrice += (int) product.getPrice();
            }
        }
        System.out.println("Общая стоимость корзины: " + totalPrice);
    }

    public void showBasket() {
        int totalProducts = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product == null) {
                    break;
                }
                totalProducts++;
                System.out.println(product);
            }
        }
        if (totalProducts == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        showBasketPrice();
    }

    public Boolean checkProduct(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена");
    }

    public void specialProduct() {
        int amountSpecial = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    amountSpecial++;
                }
            }
        }
        System.out.println("Специальных товаров: " + amountSpecial);
    }

    public String removeElementInBasket(String name) {
        List<Product> deletedElements = new LinkedList<>();
        for (List<Product> productList : products.values()) {
            for (int i = 0; i < productList.size(); i++) {
                if (name.equals(productList.get(i).getName())) {
                    deletedElements.add(productList.get(i));
                    productList.remove(i);
                }
            }
        }

        if (deletedElements.isEmpty()) return "Список удаленных продуктов пуст";
        return "Удаленные продукты: " + deletedElements;
    }

}
