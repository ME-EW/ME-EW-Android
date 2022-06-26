package com.example.domain.model

data class TodayTodo(
    val nickname: String,
    val characterName: String,
    val level: Int,
    val characterImage: String,
    val refreshCount: Int,
    val finished: Boolean
)