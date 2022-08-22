package com.example.kurlyview.presentation

import android.os.Bundle
import android.view.LayoutInflater
import com.example.kurlyview.databinding.ActivityDetailBinding
import com.example.kurlyview.presentation.view.DetailPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    private var tabLayoutMediator: TabLayoutMediator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(LayoutInflater.from(this))
    }

    private fun initView() {
        viewBinding.viewPager.adapter = DetailPagerAdapter(this)
        tabLayoutMediator = TabLayoutMediator(
            viewBinding.tabLayout,
            viewBinding.viewPager
        ) { tab: TabLayout.Tab, i: Int ->
            tab.text = Tab.values()[i].title
        }
        tabLayoutMediator?.attach()

    }

    enum class Tab(val title: String) {
        PRODUCT("상품설명"),
        INFO("상세정보"),
        REVIEW("후기"),
        HELP("문의");
    }
}