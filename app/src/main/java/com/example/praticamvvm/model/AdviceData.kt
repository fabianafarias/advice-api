package com.example.praticamvvm.model

import com.google.gson.annotations.SerializedName

data class AdviceData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("advice")
    val advice: String
) {

    fun convertToAdvice(): Advice {
        return Advice(advice)
    }
}
