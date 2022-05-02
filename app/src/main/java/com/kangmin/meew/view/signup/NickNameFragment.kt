package com.kangmin.meew.view.signup

import androidx.fragment.app.activityViewModels
import com.kangmin.base.BaseFragment
import com.kangmin.meew.MeewApplication
import com.kangmin.meew.R
import com.kangmin.meew.databinding.FragmentNickNameBinding
import gun0912.tedkeyboardobserver.TedKeyboardObserver

class NickNameFragment : BaseFragment<FragmentNickNameBinding>(R.layout.fragment_nick_name) {

    private val viewModel by activityViewModels<SignUpViewModel>()

    override fun setOnCreateView() {
    }

    override fun setOnViewCreated() {
        binding.run {
            fragment = this@NickNameFragment
            viewModel = this@NickNameFragment.viewModel
        }
    }

    fun hideKeyboard() {
        MeewApplication.mImm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}