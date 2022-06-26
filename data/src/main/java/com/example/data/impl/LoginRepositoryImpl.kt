package com.example.data.impl

import com.example.data.service.LoginService
import com.example.domain.model.User
import com.example.domain.repository.LoginRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val loginService: LoginService
) : LoginRepository {
    override suspend fun postLogin(socialToken: String): User {
        val result = loginService.postLogin(
            socialToken,
            "kakao"
        )

        return User(
            result.data.token.accessToken,
            result.data.token.refreshToken,
        )
    }
}