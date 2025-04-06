package com.hamzaazman.akaryakitfiyatlar.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FuelPriceResponse(
    @SerialName("sonYenileme")
    val sonYenileme: String,
    @SerialName("fiyatlar")
    val fiyatlar: List<FuelPriceInfo>
)