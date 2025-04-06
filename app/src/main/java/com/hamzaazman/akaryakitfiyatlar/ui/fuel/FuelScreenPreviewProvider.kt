package com.hamzaazman.akaryakitfiyatlar.ui.fuel

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class FuelScreenPreviewProvider : PreviewParameterProvider<FuelContract.UiState> {
    override val values: Sequence<FuelContract.UiState>
        get() = sequenceOf(
            FuelContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            FuelContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            FuelContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}