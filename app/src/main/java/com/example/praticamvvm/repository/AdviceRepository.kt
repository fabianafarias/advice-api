package com.example.praticamvvm.repository

import com.example.praticamvvm.model.AdviceModel
import com.example.praticamvvm.model.AdviceViewModel
import com.example.praticamvvm.response.AdviceResponse

sealed class AdviceStatus{
    data class Success(val advices : List<AdviceViewModel>) : AdviceStatus()
    class Error: AdviceStatus()
}

interface AdviceRepository{
    suspend fun getAdvice(): AdviceStatus
}
