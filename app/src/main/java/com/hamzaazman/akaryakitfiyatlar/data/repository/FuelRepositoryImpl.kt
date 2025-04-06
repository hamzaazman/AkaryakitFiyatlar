package com.hamzaazman.akaryakitfiyatlar.data.repository

import com.hamzaazman.akaryakitfiyatlar.data.model.FuelPriceResponse
import com.hamzaazman.akaryakitfiyatlar.data.source.local.FuelDao
import com.hamzaazman.akaryakitfiyatlar.data.source.remote.FuelService
import com.hamzaazman.akaryakitfiyatlar.domain.repository.FuelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class FuelRepositoryImpl @Inject constructor(
    private val fuelService: FuelService,
    private val fuelDao: FuelDao,
) : FuelRepository {

    override suspend fun fetchFuelByCity(
        station: String,
        city: Int
    ): Flow<Result<FuelPriceResponse>> {
        return flow {
            try {
                val response = fuelService.getFuelByCity(station = station, city = city)
                emit(Result.success(response))
            } catch (e: Exception) {
                emit(Result.failure(e))
            } catch (e: HttpException) {
                emit(Result.failure(e))
            } catch (e: Throwable) {
                emit(Result.failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}