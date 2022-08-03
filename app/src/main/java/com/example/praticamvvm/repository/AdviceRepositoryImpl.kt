package com.example.praticamvvm.repository

import com.example.praticamvvm.service.AdviceService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AdviceRepositoryImpl : AdviceRepository, KoinComponent {

    private val service : AdviceService by inject()

    override suspend fun getAdvice(): AdviceStatus {
        val advices = service.getAdvice()
        if (advices.isSuccessful){
            advices.body()?.slip.let {
                return AdviceStatus.Success(it)
            }
        }
        return AdviceStatus.Error()
    }
}