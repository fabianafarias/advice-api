package com.example.praticamvvm.model.remote.response

import com.example.praticamvvm.model.remote.dto.AdviceDataDTO
import com.google.gson.annotations.SerializedName

data class AdviceResponse(
    @SerializedName("slip")
    val slip: AdviceDataDTO
)
