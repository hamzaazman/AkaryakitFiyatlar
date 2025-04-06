package com.hamzaazman.akaryakitfiyatlar.ui.fuel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamzaazman.akaryakitfiyatlar.data.source.local.FuelDataStore
import com.hamzaazman.akaryakitfiyatlar.domain.model.FuelStation
import com.hamzaazman.akaryakitfiyatlar.domain.usecase.GetFuelByCityUseCase
import com.hamzaazman.akaryakitfiyatlar.ui.fuel.FuelContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class FuelViewModel @Inject constructor(
    private val getFuelByCityUseCase: GetFuelByCityUseCase,
    private val fuelDataStore: FuelDataStore
) : ViewModel() {

    companion object {
        private const val REFRESH_INTERVAL = 60_000L
    }
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()


    init {
        getFuelByCity(station = FuelStation.Opet.code.toString(), city = 67)
    }

    fun refreshFuelPrices(station: String, city: Int) {
        viewModelScope.launch {
            val storageUpdateTime = fuelDataStore.getLastUpdateTime().firstOrNull() ?: 0L
            val currentTime = System.currentTimeMillis()

            if (currentTime - storageUpdateTime > REFRESH_INTERVAL) {
                getFuelByCity(station, city)
            } else {
                _uiState.update { it.copy(error = "Yakın zamanda güncelleme yapıldı.") }
            }
        }
    }

    private fun getFuelByCity(station: String, city: Int) {
        viewModelScope.launch {
            getFuelByCityUseCase.invoke(station = station, city = city)
                .onStart {
                    _uiState.value = UiState(isLoading = true)
                }
                .onEach { result ->
                    result.onSuccess { response ->
                        val newUpdateTime = parseUpdateTime(response.sonYenileme)
                        fuelDataStore.saveLastUpdateTime(newUpdateTime)
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                list = response.fiyatlar,
                                error = null
                            )
                        }
                    }.onFailure { throwable ->
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                list = emptyList(),
                                error = throwable.message
                            )
                        }
                    }
                }.collect()
        }
    }

    private fun parseUpdateTime(dateString: String): Long {
        return try {
            val sdf = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US)
            sdf.parse(dateString)?.time ?: 0L
        } catch (e: Exception) {
            0L
        }
    }

}