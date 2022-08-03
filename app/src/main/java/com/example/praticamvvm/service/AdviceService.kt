package com.example.praticamvvm.service

import com.example.praticamvvm.response.AdviceResponse
import retrofit2.Response
import retrofit2.http.GET

interface AdviceService {

    @GET()
    suspend fun getAdvice() : Response<AdviceResponse>
}