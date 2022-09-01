package com.kangmin.meew.view.signup

import androidx.activity.viewModels
import com.kangmin.base.BaseActivity
import com.kangmin.meew.R
import com.kangmin.meew.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import gun0912.tedkeyboardobserver.TedKeyboardObserver

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private val viewModel by viewModels<SignUpViewModel>()

    override fun setObserve() {
        super.setObserve()

        TedKeyboardObserver(this).listen { isShow ->
            if (!isShow) {
                binding.root.clearFocus()
            }
        }
    }

    override fun getIntentData() {
        super.getIntentData()
        viewModel.kakaoToken = intent.getStringExtra("kakao_token") ?: ""
    }
}