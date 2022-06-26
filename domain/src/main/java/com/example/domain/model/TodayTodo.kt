package com.example.domain.model

data class TodayTodo(
    var nickname: String,
    var characterName: String,
    var level: Int,
    var characterImage: String,
    var refreshCount: Int,
    var finished: Boolean,
    var todo: List<Todo>
)