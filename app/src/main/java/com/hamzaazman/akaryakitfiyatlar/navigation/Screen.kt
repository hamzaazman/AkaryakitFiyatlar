package com.hamzaazman.akaryakitfiyatlar.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Fuel : Screen
}