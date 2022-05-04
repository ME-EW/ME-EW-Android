package com.kangmin.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity <T : ViewDataBinding>(@LayoutRes private val resId: Int) :
    AppCompatActivity() {

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        } catch (ignore: IllegalStateException) {}

        binding = DataBindingUtil.setContentView(this, resId)
        binding.run {
            lifecycleOwner = this@BaseActivity
        }
        getIntentData()
        setObserve()
        setClickEvent()
    }

    open fun getIntentData() {}
    open fun setObserve() {}
    open fun setClickEvent() {}
}