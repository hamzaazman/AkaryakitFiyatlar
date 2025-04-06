package com.hamzaazman.akaryakitfiyatlar.domain.model

import kotlin.collections.find

sealed class FuelStation(val code: String, val displayName: String) {
    object PetrolOfisi : FuelStation("po", "Petrol Ofisi")
    object Opet : FuelStation("opet", "Opet")
    object Alpet : FuelStation("alpet", "Alpet")
    object TurkiyePetrolleri : FuelStation("tp", "Türkiye Petrolleri")
    object Sunpet : FuelStation("sunpet", "Sunpet")

    companion object {
        val allStations = listOf(PetrolOfisi, Opet, Alpet, TurkiyePetrolleri, Sunpet)

        fun fromCode(code: String): FuelStation? {
            return allStations.find { it.code == code }
        }
    }
}