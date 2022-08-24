package com.example.kurlyview.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.kurlyview.data.source.local.KurlyviewDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import java.util.*

object PreferencesRepository {
    private val dataStore: DataStore<Preferences> by lazy {
        KurlyviewDataStore.instance
    }

    private object PreferencesKeys {
        val USER_DEVICE_ID = stringPreferencesKey("userDeviceId")
        val USER_TOKEN = stringPreferencesKey("userToken")
    }

    fun getUserDeviceId(): String {
        return runBlocking {
            var userDeviceId = dataStore.data.first()[PreferencesKeys.USER_DEVICE_ID]
            if (userDeviceId == null) {
                userDeviceId = UUID.randomUUID().toString()
                dataStore.edit { preference ->
                    preference[PreferencesKeys.USER_DEVICE_ID] = userDeviceId
                }
            }

            userDeviceId
        }
    }

    fun getUserToken(): String {
        return runBlocking {
            dataStore.data.first()[PreferencesKeys.USER_TOKEN] ?: ""
        }
    }

    suspend fun setUserToken(token: String) {
        dataStore.edit { preference ->
            preference[PreferencesKeys.USER_TOKEN] = token
        }
    }

}