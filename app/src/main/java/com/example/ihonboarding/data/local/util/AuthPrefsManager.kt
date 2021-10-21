package com.example.ihonboarding.data.local.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.ihonboarding.data.local.util.AuthPrefsManager.PreferenceKeys.PREVIOUS_AUTH_USER
import com.example.ihonboarding.util.PREVIOUS_USER_PREF_NAME
import com.example.ihonboarding.util.USER_PREF_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class AuthPrefsManager @Inject constructor(@ApplicationContext context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREF_NAME)
    private val dataStore = context.dataStore


    suspend fun readPreviousAuthUserEmail(): String? {
        val preferences = dataStore.data.first()
        return preferences[PREVIOUS_AUTH_USER]
    }

    val preferencesFlow: Flow<String> = dataStore.data.catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        preferences[PREVIOUS_AUTH_USER] ?: ""
    }

    suspend fun saveAuthenticatedUserToDataStore(email: String) {
        dataStore.edit { _dataStore ->
            _dataStore[PREVIOUS_AUTH_USER] = email
        }
    }

    private object PreferenceKeys {
        val PREVIOUS_AUTH_USER = stringPreferencesKey(PREVIOUS_USER_PREF_NAME)
    }
}