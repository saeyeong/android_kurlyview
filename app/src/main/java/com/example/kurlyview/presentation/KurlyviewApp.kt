package com.example.kurlyview.presentation

import android.app.Application
import timber.log.Timber

class KurlyviewApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}