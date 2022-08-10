package com.example.praticamvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praticamvvm.model.repository.AdviceRepository
import com.example.praticamvvm.model.repository.AdviceRepositoryResult
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class AdviceViewModel(
    private val repository: AdviceRepository) : ViewModel(), KoinComponent {

    private val _adviceList = MutableLiveData<AdviceViewModelResult>()
    val adviceList: LiveData<AdviceViewModelResult> get() = _adviceList

    fun adviceUpdate() {
        viewModelScope.launch {
            when(val adviceRepositoryStatus = repository.getAdvice()){
                is AdviceRepositoryResult.Error -> {
                    _adviceList.postValue(AdviceViewModelResult.Error)
                }
                is AdviceRepositoryResult.Success -> {
                    _adviceList.postValue(AdviceViewModelResult.Success(adviceRepositoryStatus.adviceDataDTO))
                }
            }
        }
    }
}