package com.example.data.impl.mock

import com.example.domain.model.CharacterInfo
import com.example.domain.model.TodayTodo
import com.example.domain.model.Todo
import com.example.domain.repository.CharacterRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryMockImpl @Inject constructor() : CharacterRepository {
    override suspend fun getCharacters(): List<CharacterInfo> {
        return emptyList()
    }

    override suspend fun getTodayTodo(): TodayTodo {
        return TodayTodo(
            nickname = "Mock",
            characterName = "적극적인 태양이",
            level = 3,
            characterImage = "",
            refreshCount = 2,
            finished = false,
            todo = listOf(
                Todo(id = "1", content = "Mock 1", complete = true),
                Todo(id = "2", content = "Mock 2", complete = false),
                Todo(id = "3", content = "Mock 3", complete = false),
                Todo(id = "4", content = "Mock 4", complete = false)
            )
        )
    }
}