package com.kangmin.meew.view.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kangmin.base.BaseActivity
import com.kangmin.meew.databinding.ActivityLoginBinding
import com.kangmin.meew.R
import com.kangmin.meew.util.Dlog
import com.kangmin.meew.view.main.MainActivity
import com.kangmin.meew.view.signup.SignUpActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            viewModel = this@LoginActivity.viewModel
        }
    }

    override fun setObserve() {
        super.setObserve()
        viewModel.toastMsg.observe(this) {
            it?.let { msg ->
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.loginSuccessState.observe(this) {
            it?.let { isSuccess ->
                if (isSuccess) {
                    startActivity(
                        Intent(this@LoginActivity, MainActivity::class.java)
                            .putExtra("kakao_token", viewModel.kakaoToken)
                    )
                } else {
                    startActivity(
                        Intent(this@LoginActivity, SignUpActivity::class.java)
                    )
                }
            }
        }
    }
}