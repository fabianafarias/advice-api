package com.example.praticamvvm.model.remote.dto

import com.google.gson.annotations.SerializedName

data class AdviceDataDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("advice")
    val advice: String
) {

    fun convertToAdvice(): AdviceDTO {
        return AdviceDTO(advice)
    }
}
