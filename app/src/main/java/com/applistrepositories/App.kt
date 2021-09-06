package com.applistrepositories

import android.app.Application
import com.applistrepositories.data.di.DataModule
import com.applistrepositories.domain.di.DomainModule
import com.applistrepositories.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}