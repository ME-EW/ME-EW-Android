package com.kangmin.meew.view.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.kangmin.base.BaseActivity
import com.kangmin.meew.databinding.ActivityLoginBinding
import com.kangmin.meew.R
import dagger.hilt.android.AndroidEntryPoint

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
    }
}