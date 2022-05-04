package com.example.domain.repository

import com.example.domain.model.User

interface UserRepository {
    suspend fun postSignUp(
        socialToken: String,
        socialType: String,
        nickName: String,
        characterIndex: Int
    ): User
}