package com.hamzaazman.akaryakitfiyatlar.di

import com.hamzaazman.akaryakitfiyatlar.data.repository.FuelRepositoryImpl
import com.hamzaazman.akaryakitfiyatlar.domain.repository.FuelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMainRepository(repositoryImpl: FuelRepositoryImpl): FuelRepository
}