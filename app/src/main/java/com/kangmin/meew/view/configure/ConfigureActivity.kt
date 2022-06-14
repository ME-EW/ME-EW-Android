package com.kangmin.meew.view.configure

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import com.kangmin.base.BaseActivity
import com.kangmin.meew.R
import com.kangmin.meew.databinding.ActivityConfigureBinding

class ConfigureActivity : BaseActivity<ActivityConfigureBinding>(R.layout.activity_configure) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBaseToolbar(binding.layoutToolbar, R.drawable.ic_back_white_18dp) {
            finish()
        }

        makeUnderline()
    }

    private fun makeUnderline() {
        val span = SpannableString(binding.btnWithdrawal.text)

        span.run {
            setSpan(UnderlineSpan(), 0, binding.btnWithdrawal.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        binding.btnWithdrawal.text = span
    }
}