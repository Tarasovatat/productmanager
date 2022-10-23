package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import ru.netology.product.Product;

public class ProductRepositoryTest {

    Product product1 = new Product(5, "Трансерфинг реальности", 2500);
    Product product2 = new Product(11, "Samsung S22", 100_000);
    Product product3 = new Product(40, "Iphone 14 ProMax", 150_000);

    @Test
    public void test() {

        ProductRepository repo = new ProductRepository();

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {

        ProductRepository repo = new ProductRepository();

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(product3.getId());

        Product[] expected = {product1, product2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }
}
