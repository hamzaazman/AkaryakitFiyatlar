package com.hamzaazman.akaryakitfiyatlar.common

object Constants {
    const val BASE_URL = "https://akaryakit-fiyatlari.vercel.app/"
    const val FUEL_PRICE_CACHE_KEY = "fuel_price_cache_key"
    const val FUEL_PRICE_CACHE_EXPIRATION_TIME = 60 * 60 * 1000L // 1 hour
    const val FUEL_PRICE_CACHE_MAX_AGE = 60 * 60 * 1000L // 1 hour
    const val FUEL_PRICE_CACHE_MAX_SIZE = 10 // 10 items
}