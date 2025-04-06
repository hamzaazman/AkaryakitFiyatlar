package com.hamzaazman.akaryakitfiyatlar.data.model

import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FuelPriceInfo(
    @PrimaryKey
    @SerialName("ilce")
    val ilce: String,
    @SerialName("benzin")
    val benzin: Double?,
    @SerialName("mazot")
    val mazot: Double?,
    @SerialName("lpg")
    val lpg: Double?
)
