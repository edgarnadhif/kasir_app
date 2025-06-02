package com.kasir.service;

import com.kasir.model.CartItem;
import com.kasir.model.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartService {
    private final List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.err.println("Produk atau kuantitas tidak valid untuk ditambahkan ke keranjang.");
            return;
        }

        boolean found = false;
        for (CartItem item : cartItems) {

            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                found = true;
                break;
            }
        }

        if (!found) {
            cartItems.add(new CartItem(product, quantity));
        }
    }

    public List<CartItem> getCartItems() {

        return Collections.unmodifiableList(cartItems);
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
        System.out.println("Keranjang telah dikosongkan.");
    }
}