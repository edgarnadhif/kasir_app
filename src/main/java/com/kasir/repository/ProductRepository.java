package com.kasir.repository;

import com.kasir.model.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    // Tambahkan beberapa produk awal untuk pengujian
    public ProductRepository() {
        products.add(new Product("Nasi Goreng", 15000.0));
        products.add(new Product("Mie Ayam", 12000.0));
        products.add(new Product("Es Teh Manis", 5000.0));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        // Mengembalikan unmodifiable list untuk mencegah modifikasi eksternal
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // Mengembalikan null jika produk tidak ditemukan
    }
}