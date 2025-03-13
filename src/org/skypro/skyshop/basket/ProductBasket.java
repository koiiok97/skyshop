package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    public List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Добавлен продукт");
    }

    public void showBasketPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            if (product == null) {
                break;
            }
            totalPrice += (int) product.getPrice();
        }
        System.out.println("Общая стоимость корзины: " + totalPrice);
    }

    public void showBasket() {
        int totalProducts = 0;
        for (Product product : products) {
            if (product == null) {
                break;
            }
            totalProducts++;
            System.out.println(product);
        }
        if (totalProducts == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        showBasketPrice();
    }

    public Boolean checkProduct(String name) {
        for (Product product : products) {
            if (name.equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена");
    }

    public void specialProduct() {
        int amountSpecial = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                amountSpecial++;
            }
        }
        System.out.println("Специальных товаров: " + amountSpecial);
    }

    public String removeElementInBasket(String name) {
        List<Product> deletedElements = new LinkedList<>();
        for (int i = 0; i < products.size(); i++) {
            if (name.equals(products.get(i).getName())) {
                deletedElements.add(products.get(i));
                products.remove(i);
            }
        }

        if (deletedElements.isEmpty()) return "Список удаленных продуктов пуст";
        return "Удаленные продукты: " + deletedElements;
    }

}
