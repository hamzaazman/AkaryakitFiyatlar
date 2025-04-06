package com.hamzaazman.akaryakitfiyatlar.domain.repository

import com.hamzaazman.akaryakitfiyatlar.data.model.FuelPriceResponse
import kotlinx.coroutines.flow.Flow

interface FuelRepository {
    suspend fun fetchFuelByCity(station: String, city: Int): Flow<Result<FuelPriceResponse>>
}