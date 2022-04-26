package com.kangmin.meew.view.signup.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.CharacterInfo
import com.kangmin.meew.databinding.ItemCharacterCardBinding
import com.kangmin.meew.difftutil.CharacterDiffUtil

class CharacterViewPagerAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var characterInfoDiffUtil = CharacterDiffUtil(this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemCharacterCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterInfoViewHolder(binding)
    }

    override fun getItemCount(): Int = characterInfoDiffUtil.size()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? CharacterInfoViewHolder)?.onBind(characterInfoDiffUtil.get(position))
    }


    class CharacterInfoViewHolder(private val binding: ItemCharacterCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CharacterInfo) {
        }
    }
}