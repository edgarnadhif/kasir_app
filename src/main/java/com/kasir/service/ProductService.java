package com.kasir.service;

import com.kasir.model.Product;
import com.kasir.repository.ProductRepository;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository; // Gunakan final untuk injeksi dependensi sederhana

    public ProductService() {
        this.productRepository = new ProductRepository(); // Inisialisasi repository
    }

    public void addProduct(String name, double price) {
        // Validasi input sederhana
        if (name == null || name.trim().isEmpty() || price <= 0) {
            System.err.println("Nama produk atau harga tidak valid.");
            return;
        }
        Product newProduct = new Product(name.trim(), price);
        productRepository.addProduct(newProduct);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
}