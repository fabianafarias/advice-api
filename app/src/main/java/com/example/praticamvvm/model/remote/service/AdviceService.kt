package com.example.praticamvvm.model.remote.service

import com.example.praticamvvm.model.remote.response.AdviceResponse
import retrofit2.Response
import retrofit2.http.GET

interface AdviceService {

    @GET("/advice")
    suspend fun getAdvice() : Response<AdviceResponse>
}