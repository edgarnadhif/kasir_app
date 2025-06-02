package com.kasir.repository;

import com.kasir.model.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product("Nasi Goreng", 15000.0));
        products.add(new Product("Mie Ayam", 12000.0));
        products.add(new Product("Es Teh Manis", 5000.0));
        products.add(new Product("Bakso", 10000.0));
        products.add(new Product("Miso", 12000.0));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {

        return Collections.unmodifiableList(products);
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}