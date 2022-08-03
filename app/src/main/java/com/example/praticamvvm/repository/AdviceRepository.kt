package com.example.praticamvvm.repository

import com.example.praticamvvm.model.AdviceViewModel

sealed class AdviceStatus{
    data class Success(val advices : List<AdviceViewModel>) : AdviceStatus()
    class Error: AdviceStatus()
}

interface AdviceRepository{
    suspend fun getAdvice(): AdviceStatus
}
