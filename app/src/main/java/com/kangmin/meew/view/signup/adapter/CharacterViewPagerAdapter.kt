package com.kangmin.meew.view.signup.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.CharacterInfo
import com.kangmin.meew.databinding.ItemCharacterCardBinding
import com.kangmin.meew.difftutil.CharacterDiffUtil
import java.lang.Exception

class CharacterViewPagerAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var characterInfoDiffUtil = CharacterDiffUtil(this)
    var itemListener: SelectCharacter? = null

    private var checkedPosition = -1

    interface SelectCharacter {
        fun onSelectCharacter(data: CharacterInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemCharacterCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterInfoViewHolder(binding)
    }

    override fun getItemCount(): Int = characterInfoDiffUtil.size()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? CharacterInfoViewHolder)?.onBind(characterInfoDiffUtil.get(position))
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            payloads.forEach { key ->
                try {
                    val payload = key as Boolean
                    (holder as? CharacterInfoViewHolder)?.onBind(
                        characterInfoDiffUtil.get(position),
                        payload
                    )
                } catch (e: Exception) {
                    onBindViewHolder(holder, position)
                }
            }
        }
    }


    inner class CharacterInfoViewHolder(
        private val binding: ItemCharacterCardBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CharacterInfo, payload: Boolean = false) {
            binding.run {
                holder = this@CharacterInfoViewHolder
                item = data
            }

            binding.layoutContainer.isSelected = payload
            binding.checkboxSelect.isChecked = payload
        }

        fun selectCharacter(data: CharacterInfo) {
            if (checkedPosition != adapterPosition) {
                itemListener?.onSelectCharacter(data) // 선택한 캐릭터 정보 반환
                if (checkedPosition != -1) // 현재 선택되어져 있는 캐릭터가 있을 경우
                    notifyItemChanged(checkedPosition, false) // 선택되어져 있는 캐릭터 선택 해제
                checkedPosition = adapterPosition
                notifyItemChanged(adapterPosition, true) // 현재 아이템을 선택
            }
        }

    }
}