package com.hamzaazman.akaryakitfiyatlar.ui.fuel

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import com.hamzaazman.akaryakitfiyatlar.ui.fuel.FuelContract.UiState

@Composable
fun FuelScreen(
    viewModel: FuelViewModel = hiltViewModel()
) {

}


@Preview(showBackground = true)
@Composable
fun FuelScreenPreview(
    @PreviewParameter(FuelScreenPreviewProvider::class) uiState: UiState,
) {
    FuelScreen(

    )
}