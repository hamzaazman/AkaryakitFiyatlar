package com.hamzaazman.akaryakitfiyatlar.di

import com.hamzaazman.akaryakitfiyatlar.common.Constants
import com.hamzaazman.akaryakitfiyatlar.data.source.remote.FuelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(30, TimeUnit.SECONDS) // Bağlantı zaman aşımı
            readTimeout(30, TimeUnit.SECONDS)    // Okuma zaman aşımı
            writeTimeout(30, TimeUnit.SECONDS)   // Yazma zaman aşımı
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY // Tüm request/response detayları
            })
        }.build()
    }


    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideFuelService(retrofit: Retrofit): FuelService {
        return retrofit.create(FuelService::class.java)
    }

}