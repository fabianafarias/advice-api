package com.example.praticamvvm.repository

import com.example.praticamvvm.model.AdviceModel

sealed class AdviceStatus{
    data class Success(val adviceModel: List<AdviceModel>?) : AdviceStatus()
    class Error: AdviceStatus()
}

interface AdviceRepository{
    suspend fun getAdvice() : AdviceStatus
}
