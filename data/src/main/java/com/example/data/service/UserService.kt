package com.example.data.service

import com.example.data.entity.response.ResponseSignUp
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {
    /** 회원가입 */
    @FormUrlEncoded
    @POST("auth/signup")
    suspend fun postSignUp(
        @Field("socialToken") socialToken: String,
        @Field("socialType") socialType: String,
        @Field("nickname") nickName: String,
        @Field("personalityId") characterIndex: Int
    ): ResponseSignUp
}