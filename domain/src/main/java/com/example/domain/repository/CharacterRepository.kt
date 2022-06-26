package com.example.domain.repository

import com.example.domain.model.CharacterInfo
import com.example.domain.model.TodayTodo

interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterInfo>
    suspend fun getTodayTodo(): TodayTodo
}