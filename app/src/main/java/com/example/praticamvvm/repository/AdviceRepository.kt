package com.example.praticamvvm.repository

import com.example.praticamvvm.AdviceApi.service.AdviceApiStatus

interface AdviceRepository{
    suspend fun getAdvice(): AdviceRepositoryStatus
}
