package com.example.kurlyview.presentation.detail.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kurlyview.presentation.detail.HelpFragment
import com.example.kurlyview.presentation.detail.InfoFragment
import com.example.kurlyview.presentation.detail.ProductFragment
import com.example.kurlyview.presentation.detail.review.ReviewFragment

class DetailPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    companion object {
        const val DETAIL_PAGER_NUM = 4
        const val PRODUCT = 0
        const val INFO = 1
        const val REVIEW = 2
        const val HELP = 3
    }

    override fun getItemCount(): Int = DETAIL_PAGER_NUM

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            PRODUCT -> ProductFragment()
            INFO -> InfoFragment()
            REVIEW -> ReviewFragment()
            HELP -> HelpFragment()
            else -> ProductFragment()
        }
    }
}