package com.example.praticamvvm.AdviceApi.service

import com.example.praticamvvm.model.AdviceData

class AdviceApi(private val adviceService: AdviceService) {

    suspend fun getAdvice(): AdviceApiStatus {
        try {
            val adviceResponse = adviceService.getAdvice()
            if (adviceResponse.isSuccessful) {
                adviceResponse.body()?.let {
                    val adviceData: AdviceData = it.slip
                    return AdviceApiStatus.Success(adviceData)

                } ?: return AdviceApiStatus.Error
            } else {
                return AdviceApiStatus.Error
            }
        } catch (
            e: Exception
        ) {
            e.printStackTrace()
            return AdviceApiStatus.Error
        }

    }

}