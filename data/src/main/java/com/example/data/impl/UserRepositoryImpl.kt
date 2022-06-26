package com.example.data.impl

import com.example.data.service.UserService
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {

    /** 회원가입 통신 결과 전달 */
    override suspend fun postSignUp(
        socialToken: String,
        socialType: String,
        nickName: String,
        characterIndex: Int
    ): User {
        val response = userService.postSignUp(socialToken, socialType, nickName, characterIndex)

        return User(
            accessToken = response.data.token.accessToken,
            refreshToken = response.data.token.refreshToken
        )
    }

}