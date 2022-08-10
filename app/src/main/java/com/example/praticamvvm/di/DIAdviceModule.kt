package com.example.praticamvvm.di

import com.example.praticamvvm.model.remote.service.AdviceApi
import com.example.praticamvvm.model.remote.service.AdviceService
import com.example.praticamvvm.model.repository.AdviceRepository
import com.example.praticamvvm.model.repository.AdviceRepositoryImpl
import com.example.praticamvvm.ui.AdviceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val adviceRetrofitModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.adviceslip.com")
            .build()
    }
}

val adviceServiceModule = module {
    single{
        get<Retrofit>().create(AdviceService::class.java)
    }
}

val adviceApiModule = module {
    single<AdviceApi>{
        AdviceApi(get<AdviceService>())
    }
}

val adviceRepositoryModule = module {
    single<AdviceRepository>{
        AdviceRepositoryImpl(get<AdviceApi>())
    }
}

val adviceViewModelModule = module {
       viewModel<AdviceViewModel>{
           AdviceViewModel(get<AdviceRepository>())
       }

}


