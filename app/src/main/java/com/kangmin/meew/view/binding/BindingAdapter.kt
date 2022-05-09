package com.kangmin.meew.view.binding

import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.domain.enum.CharacterEnum
import com.example.domain.model.CharacterInfo
import com.kangmin.meew.R

@BindingAdapter("app:characterCheckBox")
fun CheckBox.setCharacterCheckBox(character: CharacterInfo) {
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