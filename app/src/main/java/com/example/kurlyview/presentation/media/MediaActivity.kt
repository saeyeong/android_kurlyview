package com.example.kurlyview.presentation.media

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kurlyview.databinding.ActivityMediaBinding
import com.example.kurlyview.domain.Media
import com.example.kurlyview.presentation.base.BaseActivity
import com.example.kurlyview.presentation.media.view.MediaAdapter

class MediaActivity : BaseActivity<ActivityMediaBinding, MediaViewModel>() {
    companion object {
        private const val INTENT_IMAGE_URL = "imageUrl"

        fun newInstance(context: Context, media: ArrayList<Media>): Intent {
            return Intent(context, MediaActivity::class.java).putParcelableArrayListExtra(INTENT_IMAGE_URL, media)
        }
    }

    private val adapter = MediaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onIntent(intent)
        initView()
    }

    private fun onIntent(intent: Intent) {

        val mediaArray = intent.getParcelableArrayListExtra<Media>(INTENT_IMAGE_URL)
        if (mediaArray != null) {
            adapter.submitList(mediaArray)
        } else {
            finish()
        }
    }

    override fun inflateViewBinding(): ActivityMediaBinding {
        return ActivityMediaBinding.inflate(LayoutInflater.from(this))
    }

    private fun initView() {
        viewBinding.viewPager.adapter = this.adapter
    }
}