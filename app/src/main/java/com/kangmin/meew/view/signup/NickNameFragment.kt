package com.kangmin.meew.view.signup

import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.activityViewModels
import com.kangmin.base.BaseFragment
import com.kangmin.meew.MeewApplication
import com.kangmin.meew.R
import com.kangmin.meew.databinding.FragmentNickNameBinding

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

    override fun setObserve() {
        super.setObserve()
        viewModel.nickName.observe(viewLifecycleOwner) {
            DrawableCompat.wrap(binding.edtNickName.background).clearColorFilter()
        }
    }

    fun hideKeyboard() {
        MeewApplication.mImm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    fun checkNickNameDuplicated() {
        DrawableCompat.wrap(binding.edtNickName.background).colorFilter =
            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.red_500
                ), BlendModeCompat.SRC_ATOP
            )
    }
}