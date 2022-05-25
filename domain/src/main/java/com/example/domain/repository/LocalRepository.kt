package com.example.domain.repository

import com.example.domain.model.User

interface LocalRepository {
    suspend fun getUserDataInLocal(): User
    fun setUserDataInLocal(user: User)
}