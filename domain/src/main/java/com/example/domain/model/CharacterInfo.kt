package com.example.domain.model

import com.example.domain.enum.CharacterEnum

data class CharacterInfo(
    var image: String,
    var characterName: String,
    var characterInfo: String,
    var characterSelected: Boolean,
    var characterEnum: CharacterEnum
)