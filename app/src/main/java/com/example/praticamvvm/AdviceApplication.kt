package com.example.praticamvvm

import android.app.Application
import com.example.praticamvvm.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AdviceApplication  : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AdviceApplication)
            modules(
                listOf(
                    adviceRetrofitModule,
                    adviceServiceModule,
                    adviceApiModule,
                    adviceRepositoryModule
                )
            )
        }
    }


}

