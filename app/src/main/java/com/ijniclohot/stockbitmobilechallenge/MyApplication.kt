package com.ijniclohot.stockbitmobilechallenge

import android.app.Application
import com.facebook.FacebookSdk
import com.ijniclohot.dependency_injection.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApplication)
            androidLogger(Level.DEBUG)
            modules(appModules)
        }
        FacebookSdk.sdkInitialize(this)
    }
}