package com.example.data.impl

import com.example.data.entity.request.RequestLogin
import com.example.data.service.LoginService
import com.example.domain.model.User
import com.example.domain.repository.LoginRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val loginService: LoginService
) : LoginRepository {
    override suspend fun postLogin(socialToken: String): User {
        val result = loginService.postLogin(RequestLogin(socialToken, "KAKAO"))

//        if (!result.success) {
//            throw HttpException(
//                Response.error<ResponseBody>(
//                    result.status,
//                    result.message.toResponseBody("plain/text".toMediaTypeOrNull())
//                )
//            )
//        }

        return User(
            result.data.token.accessToken,
            result.data.token.refreshToken,
        )
    }
}