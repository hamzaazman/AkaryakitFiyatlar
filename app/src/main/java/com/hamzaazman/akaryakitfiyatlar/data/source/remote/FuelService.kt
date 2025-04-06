package com.hamzaazman.akaryakitfiyatlar.data.source.remote

import com.hamzaazman.akaryakitfiyatlar.data.model.FuelPriceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FuelService {

    @GET("api/{station}/{city}")
    suspend fun getFuelByCity(
        @Path("station") station: String,
        @Path("city") city: Int
    ): FuelPriceResponse
}