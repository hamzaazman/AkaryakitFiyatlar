package com.hamzaazman.akaryakitfiyatlar.ui.fuel

object FuelContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction

    sealed class UiEffect
}