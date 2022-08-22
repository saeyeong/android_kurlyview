package com.example.kurlyview.presentation.media

import android.os.Bundle
import android.view.LayoutInflater
import com.example.kurlyview.databinding.ActivityMediaBinding
import com.example.kurlyview.presentation.base.BaseActivity

class MediaActivity : BaseActivity<ActivityMediaBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    override fun inflateViewBinding(): ActivityMediaBinding {
        return ActivityMediaBinding.inflate(LayoutInflater.from(this))
    }

    private fun initView() {

    }
}