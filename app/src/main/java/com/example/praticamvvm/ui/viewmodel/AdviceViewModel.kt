package com.example.praticamvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praticamvvm.repository.AdviceRepository
import com.example.praticamvvm.repository.AdviceRepositoryImpl
import com.example.praticamvvm.repository.AdviceRepositoryStatus
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class AdviceViewModel(
    private val repository: AdviceRepository) : ViewModel(), KoinComponent {

    private val _adviceList = MutableLiveData<AdviceViewModelStatus>()
    val adviceList: LiveData<AdviceViewModelStatus> get() = _adviceList

    fun adviceUpdate() {
        viewModelScope.launch {
            when(val adviceRepositoryStatus = repository.getAdvice()){
                is AdviceRepositoryStatus.Error -> {
                    _adviceList.postValue(AdviceViewModelStatus.Error)
                }
                is AdviceRepositoryStatus.Success -> {
                    _adviceList.postValue(AdviceViewModelStatus.Success(adviceRepositoryStatus.adviceData))
                }
            }
        }
    }
}