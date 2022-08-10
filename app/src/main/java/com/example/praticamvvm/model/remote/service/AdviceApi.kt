package com.example.praticamvvm.model.remote.service

import com.example.praticamvvm.model.remote.dto.AdviceDataDTO

class AdviceApi(private val adviceService: AdviceService) {

    suspend fun getAdvice(): AdviceApiResult {
        try {
            val adviceResponse = adviceService.getAdvice()
            if (adviceResponse.isSuccessful) {
                adviceResponse.body()?.let {
                    val adviceDataDTO: AdviceDataDTO = it.slip
                    return AdviceApiResult.Success(adviceDataDTO)

                } ?: return AdviceApiResult.Error
            } else {
                return AdviceApiResult.Error
            }
        } catch (
            e: Exception
        ) {
            e.printStackTrace()
            return AdviceApiResult.Error
        }

    }

}