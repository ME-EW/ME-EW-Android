package com.example.data.entity.response

import com.google.gson.annotations.SerializedName

data class ResponseUserInfo(
    @SerializedName("token")
    val token: Token,
    @SerializedName("userId")
    val userId: Int
) {
    data class Token(
        @SerializedName("accessToken")
        val accessToken: String,
        @SerializedName("refreshToken")
        val refreshToken: String
    )
}
