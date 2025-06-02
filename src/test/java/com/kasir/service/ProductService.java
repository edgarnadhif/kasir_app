package com.kasir.service;

import com.kasir.model.Product;
import com.kasir.repository.ProductRepository;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public boolean updateProductStock(int id, int quantityChange) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            int newStock = product.getStock() + quantityChange;
            if (newStock >= 0) {
                product.setStock(newStock);
                return true;
            }
        }
        return false;
    }
}