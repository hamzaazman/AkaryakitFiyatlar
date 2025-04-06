package com.hamzaazman.akaryakitfiyatlar.domain.usecase

import com.hamzaazman.akaryakitfiyatlar.domain.repository.FuelRepository
import jakarta.inject.Inject

class GetFuelByCityUseCase @Inject constructor(
    private val repository: FuelRepository
) {
    suspend operator fun invoke(station: String, city: Int) =
        repository.fetchFuelByCity(city = city, station = station)
}