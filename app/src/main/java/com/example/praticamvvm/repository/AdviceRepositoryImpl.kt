package com.example.praticamvvm.repository

import com.example.praticamvvm.AdviceApi.service.AdviceApi
import com.example.praticamvvm.AdviceApi.service.AdviceApiStatus
import com.example.praticamvvm.model.Advice
import org.koin.core.component.KoinComponent

class AdviceRepositoryImpl(private val adviceApi: AdviceApi) : AdviceRepository, KoinComponent {

    override suspend fun getAdvice(): AdviceRepositoryStatus {
        when (val adviceApiStatus = adviceApi.getAdvice()) {
            is AdviceApiStatus.Error -> {
                return AdviceRepositoryStatus.Error
            }
            is AdviceApiStatus.Success -> {
                adviceApiStatus.adviceData.let {
                    val adviceData: Advice = it.convertToAdvice()
//                    Log.i("adviceRepository", "$adviceData")

                    return AdviceRepositoryStatus.Success(it)
                }
            }
        }

    }

}


