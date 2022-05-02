package com.kangmin.meew.view.signup

import androidx.fragment.app.activityViewModels
import com.kangmin.base.BaseFragment
import com.kangmin.meew.R
import com.kangmin.meew.databinding.FragmentNickNameBinding

class NickNameFragment : BaseFragment<FragmentNickNameBinding>(R.layout.fragment_nick_name) {

    private val viewModel by activityViewModels<SignUpViewModel>()

    override fun setOnCreateView() {
    }

    override fun setOnViewCreated() {
    }
}