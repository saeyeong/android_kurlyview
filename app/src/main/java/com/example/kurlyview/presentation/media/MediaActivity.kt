package com.example.kurlyview.presentation.media

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kurlyview.databinding.ActivityMediaBinding
import com.example.kurlyview.domain.Media
import com.example.kurlyview.presentation.album.AlbumActivity
import com.example.kurlyview.presentation.base.BaseActivity
import com.example.kurlyview.presentation.media.view.MediaAdapter

class MediaActivity : BaseActivity<ActivityMediaBinding, MediaViewModel>() {
    companion object {
        private const val INTENT_REVIEW_ID = "reviewId"

        fun newInstance(context: Context, reviewId: Int): Intent {
            return Intent(context, MediaActivity::class.java).putExtra(
                INTENT_REVIEW_ID, reviewId)

        }
    }

    private val adapter = MediaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onIntent(intent)
        initView()
    }

    private fun onIntent(intent: Intent) {

        val reviewId = intent.getIntExtra(INTENT_REVIEW_ID, -1)
        if (reviewId != -1) {
            viewModel.getReview(reviewId)
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