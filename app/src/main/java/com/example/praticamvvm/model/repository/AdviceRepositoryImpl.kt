package com.example.praticamvvm.model.repository

import com.example.praticamvvm.model.remote.service.AdviceApi
import com.example.praticamvvm.model.remote.service.AdviceApiResult
import com.example.praticamvvm.model.remote.dto.AdviceDTO
import org.koin.core.component.KoinComponent

class AdviceRepositoryImpl(private val adviceApi: AdviceApi) : AdviceRepository, KoinComponent {

    override suspend fun getAdvice(): AdviceRepositoryResult {
        when (val adviceApiStatus = adviceApi.getAdvice()) {
            is AdviceApiResult.Error -> {
                return AdviceRepositoryResult.Error
            }
            is AdviceApiResult.Success -> {
                adviceApiStatus.adviceDataDTO.let {
                    val adviceData: AdviceDTO = it.convertToAdvice()
//                    Log.i("adviceRepository", "$adviceDataDTO")

                    return AdviceRepositoryResult.Success(it)
                }
            }
        }

    }

}


