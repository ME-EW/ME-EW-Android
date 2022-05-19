package com.kangmin.meew.view.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                HomeFragment()
            }

            1 -> {
                HomeFragment()

            }

            2 -> {
                RecordHistoryFragment()
            }

            else -> {
                HomeFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}