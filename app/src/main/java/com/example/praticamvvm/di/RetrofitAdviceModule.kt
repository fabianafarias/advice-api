package com.example.praticamvvm.di

import com.example.praticamvvm.repository.AdviceRepository
import com.example.praticamvvm.repository.AdviceRepositoryImpl
import com.example.praticamvvm.service.AdviceService
import com.example.praticamvvm.ui.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val adviceRetrofitModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.adviceslip.com/")
            .build()
    }
}

val adviceServiceModule = module {
    single{
        get<Retrofit>().create(AdviceService::class.java)
    }
}

val adviceRepositoryModule = module {
    single<AdviceRepository>{
        AdviceRepositoryImpl()
    }
}

val adviceViewModel = module {
    viewModel {
        ViewModel()
    }

}