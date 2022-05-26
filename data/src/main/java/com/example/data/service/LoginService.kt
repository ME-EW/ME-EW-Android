package com.example.data.service

import com.example.data.entity.response.ResponseLogin
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {
    /** 로그인 */
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun postLogin(
        @Field("socialToken") socialToken: String,
        @Field("socialType") socialType: String
    ): ResponseLogin
}