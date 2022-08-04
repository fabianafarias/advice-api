package com.example.praticamvvm.response

import com.example.praticamvvm.model.AdviceData
import com.google.gson.annotations.SerializedName

data class AdviceResponse(
    @SerializedName("slip")
    val slip: AdviceData
)
