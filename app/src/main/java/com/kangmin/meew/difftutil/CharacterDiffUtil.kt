package com.kangmin.meew.difftutil

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.CharacterInfo

class CharacterDiffUtil(private val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {

    private val characterInfo = mutableListOf<CharacterInfo>()

    fun size(): Int = characterInfo.size

    fun get(position: Int): CharacterInfo = characterInfo[position]

    fun getAll() = characterInfo

    fun set(items: MutableList<CharacterInfo>) {
        calcDiff(items)
        setNewList(items)
    }

    fun changeItem(position: Int, item: CharacterInfo) {
        val newList = mutableListOf<CharacterInfo>()
        newList.addAll(characterInfo)
        newList.removeAt(position)
        newList.add(position, item)

        calcDiff(newList)
        setNewList(newList)
    }

    fun add(item: CharacterInfo) {
        val newList = mutableListOf<CharacterInfo>()
        newList.addAll(characterInfo)
        newList.add(item)

        calcDiff(newList)
        setNewList(newList)
    }

    fun addAll(items: MutableList<CharacterInfo>) {
        val newList = mutableListOf<CharacterInfo>()
        newList.addAll(characterInfo)
        newList.addAll(items)

        calcDiff(newList)
        setNewList(newList)
    }

    fun removeAt(position: Int) {
        val newList = mutableListOf<CharacterInfo>()
        newList.addAll(characterInfo)
        newList.removeAt(position)

        calcDiff(newList)
        setNewList(newList)
    }

    private fun setNewList(newList: MutableList<CharacterInfo>) {
        characterInfo.clear()
        characterInfo.addAll(newList)
    }


    private fun calcDiff(newList: MutableList<CharacterInfo>) {
        val diffUtilCallBack = CharacterInfoDiffUtilCallBack(characterInfo, newList)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffUtilCallBack)
        diffResult.dispatchUpdatesTo(adapter)
    }

    class CharacterInfoDiffUtilCallBack(
        private val oldList: MutableList<CharacterInfo>,
        private val newList: MutableList<CharacterInfo>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].image == newList[newItemPosition].image

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]
    }

}