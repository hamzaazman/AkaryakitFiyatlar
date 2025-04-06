package com.hamzaazman.akaryakitfiyatlar.ui.fuel

import androidx.lifecycle.ViewModel
import com.hamzaazman.akaryakitfiyatlar.ui.fuel.FuelContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FuelViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()




}