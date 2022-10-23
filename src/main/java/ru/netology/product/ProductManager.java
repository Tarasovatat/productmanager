package ru.netology.product;

import ru.netology.repository.ProductRepository;

public class ProductManager {

    // добавьте необходимые поля, конструкторы и методы
    ProductRepository repository = new ProductRepository();

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        String[] newProduct = new String[product.length + 1];
        for (int i = 0; i < product.length; i++) {
            newProduct[i] = product[i];
        }
        newProduct[newProduct.length - 1] = product;
        product = newProduct;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                result[product] = product[product];

                // "добавляем в конец" массива result продукт product
            }
            result[result.length - 1] = product;
            product = result;

        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
