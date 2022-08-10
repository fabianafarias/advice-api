package com.example.praticamvvm.model.remote.service

import com.example.praticamvvm.model.remote.dto.AdviceDataDTO

sealed class AdviceApiResult{
    data class Success(val adviceDataDTO: AdviceDataDTO) : AdviceApiResult()
    object Error: AdviceApiResult()
}
