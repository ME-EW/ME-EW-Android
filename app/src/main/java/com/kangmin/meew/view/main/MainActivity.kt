package com.kangmin.meew.view.main

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.kangmin.base.BaseActivity
import com.kangmin.meew.R
import com.kangmin.meew.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewpagerAdapter by lazy {
        MainViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            activity = this@MainActivity
        }
        initViewpager()
    }

    private fun initViewpager() {
        binding.vpMain.run {
            adapter = viewpagerAdapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    changeBottomNavigationState(position)
                }
            })
        }
    }

    private fun changeBottomNavigationState(position: Int) {
        binding.btnAlert.isSelected = position == 0
        binding.btnHome.isSelected = position == 1
        binding.btnRecord.isSelected = position == 2
    }

    /** 바텀시트 누를 때마다 페이지 변경 */
    fun changeMainContents(position: Int) {
        binding.vpMain.setCurrentItem(position, true)
    }
}