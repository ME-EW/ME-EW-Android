package com.kangmin.meew

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.kangmin.base.BaseActivity
import com.kangmin.meew.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            lifecycleOwner = this@MainActivity
        }
    }
}