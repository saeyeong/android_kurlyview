package com.example.kurlyview.presentation.album

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.kurlyview.databinding.ActivityAlbumBinding
import com.example.kurlyview.presentation.album.view.AlbumAdapter
import com.example.kurlyview.presentation.base.BaseActivity
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AlbumActivity: BaseActivity<ActivityAlbumBinding, AlbumViewModel>() {
    companion object {
        private const val INTENT_PRODUCT_ID = "productId"

        fun newInstance(context: Context, productId: Int): Intent {
            return Intent(context, AlbumActivity::class.java).putExtra(
                INTENT_PRODUCT_ID, productId)

        }
    }

    private val albumAdapter = AlbumAdapter()

    override fun inflateViewBinding(): ActivityAlbumBinding {
        return ActivityAlbumBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initViewModel()
        onIntent(intent)
    }

    private fun initView() {
        viewBinding.recyclerview.layoutManager = FlexboxLayoutManager(this).apply {
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START

        }
        viewBinding.recyclerview.adapter = albumAdapter

    }

    private fun initViewModel() {
        viewModel.reviewOrderingInfo.observe(this) {
            viewModel.getMedia(it)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pagingDataFlow.collectLatest {
                    albumAdapter.submitData(it)
                }
            }
        }
    }

    private fun onIntent(intent:Intent) {

        val productId = intent.getIntExtra(INTENT_PRODUCT_ID, -1)
        if (productId != -1) {
            viewModel.setProductId(productId)
        } else {
            finish()
        }
    }
}