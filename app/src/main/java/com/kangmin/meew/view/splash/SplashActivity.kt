package com.kangmin.meew.view.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.kangmin.base.BaseActivity
import com.kangmin.meew.R
import com.kangmin.meew.databinding.ActivitySplashBinding
import com.kangmin.meew.util.showToast
import com.kangmin.meew.view.login.LoginActivity
import com.kangmin.meew.view.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    private val splashViewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            delay(500)
            splashViewModel.checkAutoLogin()
        }
    }

    override fun setObserve() {
        super.setObserve()

        splashViewModel.run {
            userInLocal.observe(this@SplashActivity) {
                it?.let { isIn ->
                    if (isIn) {
                        splashViewModel.login()
                    } else {
                        openLoginActivity()
                    }

                }
            }

            isSuccessLogin.observe(this@SplashActivity) {
                it?.let { loginSuccess ->
                    if (loginSuccess) {
                        openMainActivity()
                    } else {
                        openLoginActivity()
                    }
                }
            }
        }
    }

    private fun openLoginActivity() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
    }

    private fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}