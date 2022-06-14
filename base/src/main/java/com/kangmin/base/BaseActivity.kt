package com.kangmin.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity <T : ViewDataBinding>(@LayoutRes private val resId: Int) :
    AppCompatActivity() {

    protected lateinit var binding: T
    private lateinit var clickToolbarHome: () -> Unit

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

    fun initBaseToolbar(view: Toolbar, @DrawableRes drawableRes: Int?, clickHome: () -> Unit) {
        setSupportActionBar(view)
        supportActionBar?.run {
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
            drawableRes?.let {
                setHomeAsUpIndicator(it)
            }
        }
        clickToolbarHome = clickHome
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                if (this::clickToolbarHome.isInitialized)
                    clickToolbarHome()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}