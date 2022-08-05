package com.example.praticamvvm.ui.viewmodel

import com.example.praticamvvm.model.AdviceData

sealed class AdviceViewModelStatus {
    data class Success(val adviceData: AdviceData) : AdviceViewModelStatus()
    object Error: AdviceViewModelStatus()

}
