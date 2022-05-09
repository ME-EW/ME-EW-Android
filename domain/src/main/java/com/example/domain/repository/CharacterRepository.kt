package com.example.domain.repository

import com.example.domain.model.CharacterInfo

interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterInfo>
}