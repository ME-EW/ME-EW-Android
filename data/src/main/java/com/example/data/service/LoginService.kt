package com.example.data.service

import com.example.data.entity.request.RequestLogin
import com.example.data.entity.response.ResponseLogin
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {
    /** 로그인 */
    @POST("auth/login")
    suspend fun postLogin(
        @Body body: RequestLogin
    ): ResponseLogin
}