package com.example.data.service

import com.example.data.entity.response.ResponseCharacter
import com.example.data.entity.response.ResponseTodayTodo
import retrofit2.http.GET

interface CharacterService {
    @GET("personality/list")
    suspend fun getCharacters(): ResponseCharacter

    /** 오늘의 캐릭터 가져오기 */
    @GET("personality/today")
    suspend fun getTodayCharacter(): ResponseTodayTodo
}