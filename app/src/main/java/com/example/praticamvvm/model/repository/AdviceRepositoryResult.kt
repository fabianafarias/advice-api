package com.example.praticamvvm.model.repository

import com.example.praticamvvm.model.remote.dto.AdviceDataDTO

sealed class AdviceRepositoryResult{
    data class Success(val adviceDataDTO: AdviceDataDTO) : AdviceRepositoryResult()
    object Error: AdviceRepositoryResult()
}
