package com.example.praticamvvm.model.repository

interface AdviceRepository{
    suspend fun getAdvice(): AdviceRepositoryResult
}
