package com.example.movieapp.android

import android.app.Application
import com.example.movieapp.android.di.appModule
import com.example.movieapp.di.getSharedModules
import org.koin.core.context.startKoin

class Movie : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(modules = appModule + getSharedModules())
        }
    }
}