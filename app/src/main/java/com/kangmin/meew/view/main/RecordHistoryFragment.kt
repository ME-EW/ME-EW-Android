package com.kangmin.meew.view.main

import com.kangmin.base.BaseFragment
import com.kangmin.meew.R
import com.kangmin.meew.databinding.FragmentRecordHistoryBinding
import com.kangmin.meew.util.showToast

class RecordHistoryFragment : BaseFragment<FragmentRecordHistoryBinding>(R.layout.fragment_record_history) {

    override fun setOnCreateView() {
    }

    override fun setOnViewCreated() {
        setToolbar()
    }

    private fun setToolbar() {
        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.ic_badge -> {
                    context.showToast("badge")
                    true
                }
                R.id.ic_configure -> {
                    context.showToast("configure")
                    true
                }
                else -> false
            }
        }
    }
}