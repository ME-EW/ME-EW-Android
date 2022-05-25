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
                    showToast(if (isIn) "자동 로그인" else "유저 정보가 없습니다.")
                    startActivity(Intent(this@SplashActivity, if (isIn) MainActivity::class.java else LoginActivity::class.java))
                    finish()
                }
            }
        }
    }
}