package com.kangmin.meew.view.main

import androidx.fragment.app.activityViewModels
import com.kangmin.base.BaseFragment
import com.kangmin.meew.R
import com.kangmin.meew.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun setOnCreateView() {
        binding.run {
            viewModel = this@HomeFragment.viewModel
        }
    }

    override fun setOnViewCreated() {
    }
}