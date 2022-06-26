package com.example.data.entity.response

import com.google.gson.annotations.SerializedName

data class ResponseTodayTodo(
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: ResponseTodayInfo
) {
    data class ResponseTodayInfo(
        @SerializedName("nickname")
        val nickname: String,
        @SerializedName("name")
        val characterName: String,
        @SerializedName("level")
        val characterLevel: Int,
        @SerializedName("imageUrl")
        val characterImage: String,
        @SerializedName("chance")
        val refreshCount: Int,
        @SerializedName("finished")
        val finished: Boolean,
        @SerializedName("todo")
        val todo: List<ResponseTodo>
    )

    data class ResponseTodo(
        @SerializedName("taskId")
        val taskId: String,
        @SerializedName("content")
        val content: String,
        @SerializedName("Boolean")
        val complete: Boolean
    )
}
