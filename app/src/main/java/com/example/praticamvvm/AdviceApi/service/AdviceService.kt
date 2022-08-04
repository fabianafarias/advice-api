package com.example.praticamvvm.AdviceApi.service

import com.example.praticamvvm.response.AdviceResponse
import retrofit2.Response
import retrofit2.http.GET

interface AdviceService {

    @GET("/advice")
    suspend fun getAdvice() : Response<AdviceResponse>
}