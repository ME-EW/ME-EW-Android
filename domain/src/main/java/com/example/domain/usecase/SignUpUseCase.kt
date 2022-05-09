package com.example.domain.usecase

import com.example.domain.enum.CharacterEnum
import com.example.domain.model.CharacterInfo
import com.example.domain.repository.CharacterRepository
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignUpUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val characterRepository: CharacterRepository
) {
    fun getCharactersDummy(): List<CharacterInfo> {
        return listOf(
            CharacterInfo(
                image = "1",
                characterName = "1",
                characterInfo = "1",
                characterSelected = false,
                characterEnum = CharacterEnum.WIND
            ),
            CharacterInfo(
                image = "2",
                characterName = "2",
                characterInfo = "2",
                characterSelected = false,
                characterEnum = CharacterEnum.WIND
            ),
            CharacterInfo(
                image = "3",
                characterName = "3",
                characterInfo = "3",
                characterSelected = false,
                characterEnum = CharacterEnum.WIND
            ),
            CharacterInfo(
                image = "4",
                characterName = "4",
                characterInfo = "4",
                characterSelected = false,
                characterEnum = CharacterEnum.WIND
            )
        )
    }

    fun getCharacters() = flow {
        kotlin.runCatching {
            characterRepository.getCharacters()
        }.onSuccess {
            emit(it)
        }.onFailure {
            throw it
        }
    }
}