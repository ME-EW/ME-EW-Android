package com.example.data.entity.response

import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    @SerializedName("data")
    val data: ResponseUserInfo,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean
)