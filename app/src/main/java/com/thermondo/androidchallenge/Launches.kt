package com.thermondo.androidchallenge

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.hamza.domain.di.launchesDomainModule
import com.hamza.local.di.localDataModule
import com.hamza.network.di.networkModule
import com.hamza.presentation.di.launchesModule

class Launches : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Launches)
            modules(listOf(networkModule, localDataModule,launchesDomainModule, launchesModule))
        }
    }
}