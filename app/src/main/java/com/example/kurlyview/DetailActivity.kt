package com.example.kurlyview

import android.view.LayoutInflater
import com.example.kurlyview.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(LayoutInflater.from(this))
    }
}