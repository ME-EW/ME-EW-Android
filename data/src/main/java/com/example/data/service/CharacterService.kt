package com.example.data.service

import com.example.data.entity.response.ResponseCharacter
import com.example.data.entity.response.ResponseTodayTodo
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH

interface CharacterService {
    @GET("personality/list")
    suspend fun getCharacters(): ResponseCharacter

    /** 오늘의 캐릭터 가져오기 */
    @GET("personality/today")
    suspend fun getTodayCharacter(): ResponseTodayTodo

    /** 캐릭터 투두 리스트 체크 */
    @FormUrlEncoded
    @PATCH("personality/check")
    suspend fun checkTodo(@Field("taskId") taskId: Int): ResponseTodayTodo

    /** 캐릭터 새로고침  */
    @GET("personality/new")
    suspend fun refreshCharacter(): ResponseTodayTodo
}