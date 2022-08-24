package com.example.kurlyview.presentation.detail.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import com.example.kurlyview.databinding.FragmentReviewBinding
import com.example.kurlyview.domain.Media
import com.example.kurlyview.domain.Review
import com.example.kurlyview.domain.TextReview
import com.example.kurlyview.presentation.album.AlbumActivity
import com.example.kurlyview.presentation.base.BaseFragment
import com.example.kurlyview.presentation.detail.review.view.ReviewAdapter
import com.example.kurlyview.presentation.detail.review.view.ReviewHeaderUiState
import com.example.kurlyview.presentation.detail.review.view.ReviewUiState
import com.example.kurlyview.presentation.detail.review.view.ThumbnailMediaAdapter
import com.example.kurlyview.presentation.media.MediaActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ReviewFragment : BaseFragment<FragmentReviewBinding, ReviewViewModel>() {

    private val reviewAdapter = ReviewAdapter()
    override fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentReviewBinding {
        return FragmentReviewBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    private fun initView() {

        viewBinding.recyclerView.adapter = reviewAdapter

    }

    private fun initViewModel() {
        viewModel.reviewUiState.observe(viewLifecycleOwner) {

            reviewAdapter.setListener(object : ReviewAdapter.Listener {
                override fun onClickGoAlbum() {
                    val intent = AlbumActivity.newInstance(
                        requireContext(),
                        it.header?.productId ?: return
                    )
                    startActivity(intent)
                }

                override fun onClickMedia(id: Int) {
                    val intent = MediaActivity.newInstance(requireContext(), id)
                    startActivity(intent)
                }
            })



            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.pagingDataFlow.collectLatest {
                        reviewAdapter.submitData(it)
                    }
                }
            }
        }

    }

}