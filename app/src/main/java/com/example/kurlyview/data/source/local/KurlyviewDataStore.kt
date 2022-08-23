package com.example.kurlyview.data.source.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object KurlyviewDataStore {

    private const val USER_PREFERENCES_NAME = "user_preferences"

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES_NAME)

    lateinit var instance: DataStore<Preferences>

    fun init(context: Context) {
        instance = context.dataStore
    }
}