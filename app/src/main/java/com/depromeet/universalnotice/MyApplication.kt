package com.depromeet.universalnotice

import android.app.Application
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)
    }
}