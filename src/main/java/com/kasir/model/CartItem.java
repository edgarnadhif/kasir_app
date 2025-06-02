package com.kasir.model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
a
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    // Metode toString opsional untuk debugging
    @Override
    public String toString() {
        return "CartItem{" +
               "product=" + product.getName() +
               ", quantity=" + quantity +
               ", totalPrice=" + getTotalPrice() +
               '}';
    }
}