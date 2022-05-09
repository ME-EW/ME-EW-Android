package com.example.domain.util

import com.example.domain.enum.CharacterEnum

fun Int.getCharacter(): CharacterEnum {
    return when(this) {
        CharacterEnum.WIND.code -> CharacterEnum.WIND
        CharacterEnum.SUN.code -> CharacterEnum.SUN
        CharacterEnum.SKY.code -> CharacterEnum.SKY
        CharacterEnum.HONESTY.code -> CharacterEnum.HONESTY
        CharacterEnum.FLOWER.code -> CharacterEnum.FLOWER
        CharacterEnum.CLOUD.code -> CharacterEnum.CLOUD
        CharacterEnum.DIRECTION.code -> CharacterEnum.DIRECTION
        CharacterEnum.MIND.code -> CharacterEnum.MIND
        else -> CharacterEnum.WIND
    }
}