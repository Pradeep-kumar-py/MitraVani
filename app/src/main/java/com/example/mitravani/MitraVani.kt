package com.example.mitravani

import android.app.Application
import com.example.mitravani.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MitraVani : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MitraVani)
            modules(appModules)
        }
    }
}