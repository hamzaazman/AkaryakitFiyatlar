package com.hamzaazman.akaryakitfiyatlar.ui.fuel

import com.hamzaazman.akaryakitfiyatlar.data.model.FuelPriceInfo

object FuelContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<FuelPriceInfo> = emptyList(),
        val error: String? = null,
    )

    sealed class UiAction

    sealed class UiEffect
}