package com.kangmin.meew.view.binding

import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.domain.enum.CharacterEnum
import com.example.domain.model.CharacterInfo
import com.kangmin.meew.R
import com.kangmin.meew.character.CharacterDetailEnum

@BindingAdapter("app:roundCheckBox")
fun CheckBox.setRoundCheckBox(character: CharacterInfo) {
    this.buttonDrawable =
        ContextCompat.getDrawable(
            this.context,
            when(character.characterEnum) {
                CharacterEnum.WIND -> {
                    R.drawable.select_round_check_purple
                }

                CharacterEnum.SUN -> {
                    R.drawable.select_round_check_red
                }

                CharacterEnum.SKY -> {
                    R.drawable.select_round_check_blue
                }

                CharacterEnum.HONESTY -> {
                    R.drawable.select_round_check_pink
                }

                CharacterEnum.FLOWER -> {
                    R.drawable.select_round_check_orange
                }

                CharacterEnum.CLOUD -> {
                    R.drawable.select_round_check_coral
                }

                CharacterEnum.DIRECTION -> {
                    R.drawable.select_round_check_light_green
                }

                CharacterEnum.MIND -> {
                    R.drawable.select_round_check_yellow
                }
                else -> {
                    R.drawable.select_round_check_blue
                }
            }
        )
}

@BindingAdapter("app:squareCheckBox")
fun CheckBox.setSquareCheckBox(id: Int) {
    val drawable =
        ContextCompat.getDrawable(
            this.context,
            when(id) {
                CharacterDetailEnum.BARAM.id -> {
                    R.drawable.selector_square_check_purple_24dp
                }
                CharacterDetailEnum.TAEYANG.id -> {
                    R.drawable.selector_square_check_red_24dp
                }
                CharacterDetailEnum.HANEUL.id -> {
                    R.drawable.selector_square_check_blue_24dp
                }
                CharacterDetailEnum.JUNGJIK.id -> {
                    R.drawable.selector_square_check_pink_24dp
                }
                CharacterDetailEnum.KOTNIM.id -> {
                    R.drawable.selector_square_check_orange_24dp
                }
                CharacterDetailEnum.GUREUM.id -> {
                    R.drawable.selector_square_check_coral_24dp
                }
                CharacterDetailEnum.BANGHYANG.id -> {
                    R.drawable.selector_square_check_green_24dp
                }
                CharacterDetailEnum.MAEUM.id -> {
                    R.drawable.selector_square_check_yellow_24dp
                }
                else -> {
                    R.drawable.selector_square_check_purple_24dp
                }
            }
        )

    this.run {
        buttonDrawable = null
        setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
    }
}