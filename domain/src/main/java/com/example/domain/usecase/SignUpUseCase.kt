package com.example.domain.usecase

import com.example.domain.model.CharacterInfo
import com.example.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignUpUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    fun getCharacters(): List<CharacterInfo> {
        return listOf(
            CharacterInfo(
                image = "1",
                characterName = "1",
                characterInfo = "1",
                characterSelected = false
            ),
            CharacterInfo(
                image = "2",
                characterName = "2",
                characterInfo = "2",
                characterSelected = false
            ),
            CharacterInfo(
                image = "3",
                characterName = "3",
                characterInfo = "3",
                characterSelected = false
            ),
            CharacterInfo(
                image = "4",
                characterName = "4",
                characterInfo = "4",
                characterSelected = false
            )
        )
    }
}