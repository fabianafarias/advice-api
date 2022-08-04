package com.example.praticamvvm.repository

import com.example.praticamvvm.model.AdviceData

sealed class AdviceRepositoryStatus{
    data class Success(val adviceData: AdviceData) : AdviceRepositoryStatus()
    object Error: AdviceRepositoryStatus()
}
