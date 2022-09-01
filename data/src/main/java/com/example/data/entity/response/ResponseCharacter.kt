package com.example.data.entity.response

import com.google.gson.annotations.SerializedName

data class ResponseCharacter(
    @SerializedName("data")
    val data: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("personalities")
        val personalities: List<ResponseCharacterInfo>
    )

    data class ResponseCharacterInfo(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("createdAt")
        val createdDate: String,
        @SerializedName("updatedAt")
        val updatedDate: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("mainImg")
        val mainImg: String,
        @SerializedName("imgUrl")
        val images: List<String>
    )
}