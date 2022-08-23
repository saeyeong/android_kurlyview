package com.example.kurlyview.presentation

import android.app.Application
import com.example.kurlyview.data.ReviewRepository
import com.example.kurlyview.data.PreferencesRepository
import com.example.kurlyview.data.source.local.KurlyviewDataStore
import kotlinx.coroutines.runBlocking
import timber.log.Timber

class KurlyviewApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        KurlyviewDataStore.init(this)
        if (PreferencesRepository.getUserToken().isEmpty()) {
            val userDeviceId = PreferencesRepository.getUserDeviceId()
            runBlocking {
                ReviewRepository.login(userDeviceId).collect{
                    PreferencesRepository.setUserToken(it.token ?: "")
                }
            }
        }
    }
}