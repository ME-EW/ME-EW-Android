package com.example.data.entity.response

import com.google.gson.annotations.SerializedName

data class ResponseCharacter(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("description")
        val description: String,
        @SerializedName("imageUrl")
        val imageUrl: String,
        @SerializedName("name")
        val name: String
    )
}