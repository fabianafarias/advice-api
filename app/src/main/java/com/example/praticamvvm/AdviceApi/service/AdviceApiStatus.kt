package com.example.praticamvvm.AdviceApi.service

import com.example.praticamvvm.model.AdviceData

sealed class AdviceApiStatus{
    data class Success(val adviceData: AdviceData) : AdviceApiStatus()
    object Error: AdviceApiStatus()
}
