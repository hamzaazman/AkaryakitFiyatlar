package com.hamzaazman.akaryakitfiyatlar.di

import android.content.Context
import androidx.room.Room
import com.hamzaazman.akaryakitfiyatlar.data.source.local.FuelDao
import com.hamzaazman.akaryakitfiyatlar.data.source.local.MainRoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): MainRoomDB {
        return Room.databaseBuilder(
            context,
            MainRoomDB::class.java,
            MainRoomDB::class.simpleName
        ).build()
    }

    @Provides
    fun provideMainDao(database: MainRoomDB): FuelDao = database.mainDao()
}