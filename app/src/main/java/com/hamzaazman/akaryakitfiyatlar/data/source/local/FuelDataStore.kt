package com.hamzaazman.akaryakitfiyatlar.data.source.local

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FuelDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        val LAST_UPDATE_TIME_KEY = longPreferencesKey("last_update_time")
    }

    suspend fun saveLastUpdateTime(time: Long) {
        dataStore.edit { preferences ->
            preferences[LAST_UPDATE_TIME_KEY] = time
        }
    }

    fun getLastUpdateTime(): Flow<Long?> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[LAST_UPDATE_TIME_KEY]
            }
    }
}