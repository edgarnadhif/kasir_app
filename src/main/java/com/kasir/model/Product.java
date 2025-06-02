package com.kasir.model;

public class Product {
    private static int nextId = 1; // Untuk ID unik produk
    private int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Metode toString opsional untuk debugging
    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", price=" + price +
               '}';
    }
}