package com.example.kurlyview.presentation.detail.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import com.example.kurlyview.databinding.FragmentReviewBinding
import com.example.kurlyview.domain.Media
import com.example.kurlyview.presentation.base.BaseFragment
import com.example.kurlyview.presentation.detail.review.view.ReviewAdapter
import com.example.kurlyview.presentation.detail.review.view.ThumbnailMediaAdapter
import com.example.kurlyview.presentation.media.MediaActivity

class ReviewFragment : BaseFragment<FragmentReviewBinding, ReviewViewModel>() {

    private val reviewAdapter = ReviewAdapter()
    override fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentReviewBinding {
        return FragmentReviewBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        reviewAdapter.setListener(object : ReviewAdapter.Listener {
            override fun onClickMedia(id: Int) {
                val intent = MediaActivity.newInstance(requireContext(), getTestData())
                startActivity(intent)
            }
        })
        viewBinding.recyclerView.adapter = reviewAdapter

    }

    private fun getTestData(): ArrayList<Media> {
        val media = arrayListOf<Media>()
        media.add(Media(
            photoUrl = "https://user-images.githubusercontent.com/57159843/185928438-372a7282-c6d3-4955-aa8d-64209af745b1.jpeg",
            videoUrl = "https://d1qahxl3037dik.cloudfront.net/output/video1/Default/MP4/video1.mp4"
        ))
        for(i in 0..3) {
            media.add(Media(
                photoUrl = "https://user-images.githubusercontent.com/57159843/185928438-372a7282-c6d3-4955-aa8d-64209af745b1.jpeg",
                videoUrl = null
            ))
        }
        return media
    }

}