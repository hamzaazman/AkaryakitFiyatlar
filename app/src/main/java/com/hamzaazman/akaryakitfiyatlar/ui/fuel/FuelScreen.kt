package com.hamzaazman.akaryakitfiyatlar.ui.fuel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hamzaazman.akaryakitfiyatlar.domain.model.FuelStation
import com.hamzaazman.akaryakitfiyatlar.ui.components.EmptyScreen
import com.hamzaazman.akaryakitfiyatlar.ui.components.FuelPriceItem
import com.hamzaazman.akaryakitfiyatlar.ui.components.HomeTopBar
import com.hamzaazman.akaryakitfiyatlar.ui.components.LoadingBar
import com.hamzaazman.akaryakitfiyatlar.ui.fuel.FuelContract.UiState
import kotlinx.coroutines.launch

@Composable
fun FuelScreen(
    viewModel: FuelViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            HomeTopBar(
                uiState = uiState,
                onMenuClick = {
                    scope.launch {
                        viewModel.refreshFuelPrices(
                            station = FuelStation.Opet.code.toString(),
                            city = 67
                        )
                    }
                },
            )
        }
    ) { paddingValues ->
        FuelContent(
            uiState = uiState,
            modifier = Modifier.padding(paddingValues),
        )
    }

}

@Composable
fun FuelContent(uiState: UiState, modifier: Modifier) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.error != null -> EmptyScreen()
        else -> {
            Column {
                LazyColumn(
                    modifier = modifier.weight(1f),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(uiState.list, key = { it.ilce }) { priceInfo ->
                        FuelPriceItem(
                            priceInfo = priceInfo,
                        )
                    }
                }
            }
        }
    }
}