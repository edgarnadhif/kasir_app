package com.kasir; // Package ini sesuai dengan lokasi file

import com.kasir.model.Product;
import com.kasir.model.CartItem;
import com.kasir.service.CartService;
import com.kasir.service.ProductService;
import com.kasir.util.CurrencyUtil;

import java.util.List;
import java.util.Scanner;

public class KasirApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        CartService cartService = new CartService();

        System.out.println("=== Aplikasi Kasir ===");

        while (true) {
            System.out.println("\n1. Tambah Produk");
            System.out.println("2. Lihat Produk");
            System.out.println("3. Tambah ke Keranjang");
            System.out.println("4. Lihat Keranjang");
            System.out.println("5. Checkout");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Nama produk: ");
                    String name = scanner.nextLine();
                    System.out.print("Harga: ");
                    double price = scanner.nextDouble();
                    productService.addProduct(name, price);
                    System.out.println("Produk ditambahkan.");
                }
                case 2 -> {
                    List<Product> products = productService.getAllProducts();
                    System.out.println("Daftar Produk:");
                    if (products.isEmpty()) {
                        System.out.println("Belum ada produk.");
                    } else {
                        for (int i = 0; i < products.size(); i++) {
                            Product p = products.get(i);
                            System.out.printf("%d. %s - %s%n", i + 1, p.getName(), CurrencyUtil.format(p.getPrice()));
                        }
                    }
                }
                case 3 -> {
                    List<Product> products = productService.getAllProducts();
                    if (products.isEmpty()) {
                        System.out.println("Belum ada produk untuk ditambahkan ke keranjang.");
                        break;
                    }
                    System.out.print("Pilih nomor produk: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine(); // consume newline
                    System.out.print("Jumlah: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (index >= 0 && index < products.size()) {
                        cartService.addToCart(products.get(index), qty);
                        System.out.println("Produk ditambahkan ke keranjang.");
                    } else {
                        System.out.println("Produk tidak valid.");
                    }
                }
                case 4 -> {
                    List<CartItem> cart = cartService.getCartItems();
                    System.out.println("Isi Keranjang:");
                    if (cart.isEmpty()) {
                        System.out.println("Keranjang kosong.");
                    } else {
                        for (CartItem item : cart) {
                            System.out.printf("- %s x%d = %s%n", item.getProduct().getName(), item.getQuantity(),
                                    CurrencyUtil.format(item.getTotalPrice()));
                        }
                        System.out.println("Total: " + CurrencyUtil.format(cartService.calculateTotal()));
                    }
                }
                case 5 -> {
                    double total = cartService.calculateTotal();
                    if (total == 0) {
                        System.out.println("Keranjang kosong, tidak ada yang perlu di-checkout.");
                    } else {
                        System.out.println("Total belanja: " + CurrencyUtil.format(total));
                        System.out.println("Terima kasih sudah berbelanja!");
                        cartService.clearCart(); // Kosongkan keranjang setelah checkout
                    }
                    // Aplikasi akan keluar jika memilih 5 atau 0
                    return;
                }
                case 0 -> {
                    System.out.println("Keluar dari aplikasi.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}