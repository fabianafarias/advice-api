package com.example.praticamvvm.di

import com.example.praticamvvm.service.AdviceService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitAdviceModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.adviceslip.com/advice")
            .build()
    }
}

val adviceServiceModule = module {
    single{
        get<Retrofit>().create(AdviceService::class.java)
    }
}