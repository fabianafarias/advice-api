package com.example.praticamvvm.ui.viewmodel

import com.example.praticamvvm.model.remote.dto.AdviceDataDTO

sealed class AdviceViewModelResult {
    data class Success(val adviceDataDTO: AdviceDataDTO) : AdviceViewModelResult()
    object Error: AdviceViewModelResult()

}
