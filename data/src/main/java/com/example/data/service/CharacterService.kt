package com.example.data.service

import com.example.data.entity.response.ResponseCharacter
import retrofit2.http.GET

interface CharacterService {
    @GET("personality/list")
    suspend fun getCharacters(): ResponseCharacter
}