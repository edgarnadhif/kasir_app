package com.kasir.util;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    // Buat instance Locale sekali saja sebagai konstanta
    private static final Locale INDONESIAN_LOCALE = new Locale("id", "ID");

    public static String format(double amount) {
        // Gunakan konstanta Locale yang sudah dibuat
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(INDONESIAN_LOCALE);
        return currencyFormat.format(amount);
    }
}