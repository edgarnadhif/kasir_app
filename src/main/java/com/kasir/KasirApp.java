package com.kasir;

import java.util.*;

public class KasirApp {

    static class Barang {
        String kode, nama;
        int harga;

        Barang(String kode, String nama, int harga) {
            this.kode = kode;
            this.nama = nama;
            this.harga = harga;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar barang tetap
        List<Barang> katalog = List.of(
                new Barang("001", "Indomie Goreng", 3000),
                new Barang("002", "Aqua 600ml", 4000),
                new Barang("003", "SilverQueen 65gr", 12000),
                new Barang("004", "Kopi ABC Sachet", 2500));

        List<Barang> keranjang = new ArrayList<>();
        List<Integer> jumlah = new ArrayList<>();

        System.out.println("=== Selamat Datang di MiniMarket GPT ===");
        System.out.println("\nDaftar Barang:");
        for (Barang b : katalog) {
            System.out.printf("[%s] %-20s - Rp %,d\n", b.kode, b.nama, b.harga);
        }

        // Input transaksi
        while (true) {
            System.out.print("\nMasukkan kode barang: ");
            String kode = scanner.nextLine();

            Barang dipilih = katalog.stream()
                    .filter(b -> b.kode.equals(kode))
                    .findFirst()
                    .orElse(null);

            if (dipilih == null) {
                System.out.println("⚠️ Kode barang tidak ditemukan.");
                continue;
            }

            System.out.print("Jumlah: ");
            int qty = scanner.nextInt();
            scanner.nextLine(); // flush

            keranjang.add(dipilih);
            jumlah.add(qty);

            System.out.print("Tambah barang lagi? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y"))
                break;
        }

        // Metode pembayaran
        System.out.print("\nMetode Pembayaran (tunai/ewallet): ");
        String metode = scanner.nextLine();

        // Hitung total
        int subtotal = 0;
        for (int i = 0; i < keranjang.size(); i++) {
            subtotal += keranjang.get(i).harga * jumlah.get(i);
        }

        int diskon = (subtotal >= 100000) ? (int) (subtotal * 0.1) : 0;
        int totalBayar = subtotal - diskon;

        int bayar = 0;
        if (metode.equalsIgnoreCase("tunai")) {
            System.out.print("Masukkan uang bayar: Rp ");
            bayar = scanner.nextInt();
        }

        // Cetak struk
        System.out.println("\n====== Struk Belanja ======");
        for (int i = 0; i < keranjang.size(); i++) {
            Barang b = keranjang.get(i);
            int qty = jumlah.get(i);
            int total = b.harga * qty;
            System.out.printf("%-18s x%d = Rp %,d\n", b.nama, qty, total);
        }

        System.out.println("-------------------------------");
        System.out.printf("Subtotal         : Rp %,d\n", subtotal);
        System.out.printf("Diskon           : Rp %,d\n", diskon);
        System.out.printf("Total Bayar      : Rp %,d\n", totalBayar);

        if (metode.equalsIgnoreCase("tunai")) {
            int kembalian = bayar - totalBayar;
            System.out.printf("Tunai            : Rp %,d\n", bayar);
            System.out.printf("Kembalian        : Rp %,d\n", kembalian);
        }

        System.out.printf("Metode Pembayaran: %s\n", metode.toUpperCase());
        System.out.println("===================================");
        System.out.println("Terima kasih sudah berbelanja!");

        scanner.close();
    }
}
