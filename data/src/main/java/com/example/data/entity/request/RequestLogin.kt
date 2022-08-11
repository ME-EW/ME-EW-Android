package com.example.data.entity.request

import com.google.gson.annotations.SerializedName

data class RequestLogin(
    @SerializedName("socialToken")
    val socialToken: String,
    @SerializedName("socialType")
    val socialType: String
)
