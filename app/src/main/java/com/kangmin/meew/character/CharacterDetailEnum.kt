package com.kangmin.meew.character

import androidx.annotation.ColorRes
import com.kangmin.meew.R

enum class CharacterDetailEnum(val id: Int, val character: String, @ColorRes val color: Int) {
    BARAM(1, "즉흥적인 바람이", R.color.main_purple_500),
    TAEYANG(2, "적극적인 태양이", R.color.red_500),
    HANEUL(3, "참을성 있는 하늘이", R.color.blue_500),
    JUNGJIK(4, "성실한 정직이", R.color.pink_500),
    KOTNIM(5, "긍정적인 꽃잎이", R.color.orange_500),
    GUREUM(6, "공감하는 구름이", R.color.pink_400),
    BANGHYANG(7, "논리적인 방향이", R.color.green_500),
    MAEUM(8, "배려심 있는 마음이", R.color.yellow_500)
}