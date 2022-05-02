package com.kangmin.meew.view.signup

import android.os.Bundle
import androidx.activity.viewModels
import com.kangmin.base.BaseActivity
import com.kangmin.meew.R
import com.kangmin.meew.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import gun0912.tedkeyboardobserver.TedKeyboardObserver

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setObserve() {
        super.setObserve()

        TedKeyboardObserver(this).listen { isShow ->
            if (!isShow) {
                binding.root.clearFocus()
            }
        }
    }
}