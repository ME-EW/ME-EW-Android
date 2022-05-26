package com.example.domain.repository

import com.example.domain.model.User

interface LoginRepository {
    suspend fun postLogin(socialToken: String): User
}