package com.example.kurlyview.presentation.album

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kurlyview.databinding.ActivityAlbumBinding
import com.example.kurlyview.presentation.base.BaseActivity

class AlbumActivity: BaseActivity<ActivityAlbumBinding, AlbumViewModel>() {
    companion object {
        private const val INTENT_REVIEW_ID = "imageUrl"

        fun newInstance(context: Context, reviewId: Int): Intent {
            return Intent(context, AlbumActivity::class.java).putExtra(
                INTENT_REVIEW_ID, reviewId)

        }
    }

    override fun inflateViewBinding(): ActivityAlbumBinding {
        return ActivityAlbumBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}