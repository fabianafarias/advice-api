package com.example.praticamvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praticamvvm.model.Advice
import com.example.praticamvvm.repository.AdviceRepositoryImpl
import com.example.praticamvvm.repository.AdviceRepositoryStatus
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AdviceViewModel : ViewModel(), KoinComponent {

    private val repository: AdviceRepositoryImpl by inject()

    private val _adviceList = MutableLiveData<AdviceViewModelStatus>()
    val adviceList: LiveData<AdviceViewModelStatus> get() = _adviceList

    private val _adviceError = MutableLiveData<AdviceViewModelStatus>()
    val adviceError: LiveData<AdviceViewModelStatus> get() = _adviceError

    suspend fun getAdvice(): AdviceViewModelStatus {
        when (val adviceRepositoryStatus = repository.getAdvice()) {
            is AdviceRepositoryStatus.Error -> {
                return AdviceViewModelStatus.Error
            }
            is AdviceRepositoryStatus.Success -> {
                adviceRepositoryStatus.adviceData.let {
                    val adviceData: Advice = it.convertToAdvice()
                    Log.i("adviceViewModel", "$adviceData")

                    return AdviceViewModelStatus.Success(it)
                }
            }
        }


    }
}