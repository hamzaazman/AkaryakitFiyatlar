package com.hamzaazman.akaryakitfiyatlar.data.repository

import com.hamzaazman.akaryakitfiyatlar.data.source.local.FuelDao
import com.hamzaazman.akaryakitfiyatlar.data.source.remote.FuelService
import com.hamzaazman.akaryakitfiyatlar.domain.repository.FuelRepository
import javax.inject.Inject

class FuelRepositoryImpl @Inject constructor(
    private val fuelService: FuelService,
    private val fuelDao: FuelDao,
) : FuelRepository