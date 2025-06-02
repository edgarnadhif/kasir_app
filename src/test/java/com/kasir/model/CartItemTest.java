package com.kasir.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartItemTest {

    private Product sampleProduct1;
    private Product sampleProduct2;

    @Before // Metode ini akan dijalankan sebelum setiap test
    public void setUp() {
        // --- PERUBAHAN PENTING DI SINI ---
        // Panggil konstruktor Product yang sesuai dengan definisi Product.java Anda yang baru:
        // Product(String name, double price) ATAU Product(String name, double price, int stock)
        // Jika Anda ingin menginisialisasi stok langsung, gunakan konstruktor 3 parameter.
        // ID akan di-generate otomatis oleh kelas Product.
        Product.resetNextId(); // Penting: Reset ID generator agar ID produk bisa diprediksi untuk test
                               // Product "Nasi Goreng" (di ProductRepository) akan jadi ID 1,
                               // Product "Laptop Gaming" (di sini) akan jadi ID berikutnya
        sampleProduct1 = new Product("Laptop Gaming", 15000000.0, 10); // Ini akan punya ID 1
        sampleProduct2 = new Product("Mouse Wireless", 250000.0, 50); // Ini akan punya ID 2
        // --- AKHIR PERUBAHAN PENTING ---
    }

    @Test // Test untuk konstruktor dan getter
    public void testCartItemCreationAndGetters() {
        int quantity = 2;
        CartItem cartItem = new CartItem(sampleProduct1, quantity);

        assertNotNull("CartItem seharusnya tidak null setelah dibuat", cartItem);
        assertEquals("Produk di CartItem seharusnya sesuai", sampleProduct1, cartItem.getProduct());
        assertEquals("Kuantitas di CartItem seharusnya sesuai", quantity, cartItem.getQuantity());
    }

    @Test // Test untuk metode setQuantity
    public void testSetQuantity() {
        CartItem cartItem = new CartItem(sampleProduct1, 1);
        int newQuantity = 5;
        cartItem.setQuantity(newQuantity);

        assertEquals("Kuantitas seharusnya berubah menjadi " + newQuantity, newQuantity, cartItem.getQuantity());
    }

    @Test // Test untuk perhitungan total harga
    public void testGetTotalPrice() {
        CartItem cartItem1 = new CartItem(sampleProduct1, 1);
        assertEquals("Total harga seharusnya sama dengan harga produk untuk kuantitas 1",
                     sampleProduct1.getPrice() * 1, cartItem1.getTotalPrice(), 0.001);

        CartItem cartItem2 = new CartItem(sampleProduct1, 3);
        assertEquals("Total harga seharusnya (harga produk * 3)",
                     sampleProduct1.getPrice() * 3, cartItem2.getTotalPrice(), 0.001);

        CartItem cartItem3 = new CartItem(sampleProduct2, 0);
        assertEquals("Total harga seharusnya 0 untuk kuantitas 0",
                     sampleProduct2.getPrice() * 0, cartItem3.getTotalPrice(), 0.001);
    }

    @Test // Test untuk perilaku setQuantity dengan nilai negatif
    public void testSetQuantityToNegative() {
        CartItem cartItem = new CartItem(sampleProduct1, 10);
        cartItem.setQuantity(-5);
        assertEquals("Kuantitas seharusnya menjadi -5", -5, cartItem.getQuantity());
    }

    @Test // Test untuk metode toString
    public void testToString() {
        CartItem cartItem = new CartItem(sampleProduct2, 2);
        String expectedToString = "CartItem{product=Mouse Wireless, quantity=2, totalPrice=" + (sampleProduct2.getPrice() * 2) + "}";
        assertEquals("Metode toString() seharusnya menghasilkan output yang benar", expectedToString, cartItem.toString());
    }
}