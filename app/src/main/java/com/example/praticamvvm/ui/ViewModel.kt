package com.example.praticamvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praticamvvm.model.AdviceModel
import com.example.praticamvvm.model.AdviceViewModel
import com.example.praticamvvm.repository.AdviceRepository
import com.example.praticamvvm.repository.AdviceStatus
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ViewModel : ViewModel(), KoinComponent {

    private val adviceRepository : AdviceRepository by inject()

    private val _adviceList = MutableLiveData<List<AdviceViewModel>?>()
    val adviceList: LiveData<List<AdviceViewModel>?> get() = _adviceList

    private val _adviceErrorList = MutableLiveData<Boolean>()
    val adviceErrorList: LiveData<Boolean> get() = _adviceErrorList

    suspend fun getAdvice(){
        when(val slip = adviceRepository.getAdvice()){
            is AdviceStatus.Success -> {
                _adviceList.postValue(slip.advices)
            }
            else -> {
                _adviceErrorList.postValue(true)
            }
        }
    }
}