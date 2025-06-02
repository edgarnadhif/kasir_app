
package com.kasir.model;

public class Product {
    private static int nextId = 1;
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.stock = 0;
    }

    public Product(String name, double price, int stock) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static void resetNextId() {
        nextId = 1;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + name + ", Harga: " + price + ", Stok: " + stock;
    }
}