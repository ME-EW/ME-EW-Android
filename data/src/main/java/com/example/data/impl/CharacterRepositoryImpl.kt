package com.example.data.impl

import com.example.data.service.CharacterService
import com.example.domain.model.CharacterInfo
import com.example.domain.repository.CharacterRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val characterService: CharacterService
) : CharacterRepository {
    override suspend fun getCharacters(): List<CharacterInfo> {
        val callbackResult = characterService.getCharacters()
        val result = mutableListOf<CharacterInfo>()

        callbackResult.data.forEach { character ->
            result.add(
                CharacterInfo(
                    image = character.imageUrl,
                    characterName = character.name,
                    characterInfo = character.description,
                    characterSelected = false
                )
            )
        }

        return result
    }
}