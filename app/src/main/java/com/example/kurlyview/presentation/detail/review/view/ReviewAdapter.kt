package com.example.kurlyview.presentation.detail.review.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kurlyview.databinding.ViewReviewBinding
import com.example.kurlyview.databinding.ViewReviewHeaderBinding
import com.example.kurlyview.domain.MediaReview
import com.example.kurlyview.domain.RecipeReview
import com.example.kurlyview.domain.Review
import com.example.kurlyview.domain.TextReview
import java.lang.Exception

class ReviewAdapter: ListAdapter<ReviewUiState, RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<ReviewUiState>() {
        override fun areItemsTheSame(oldItem: ReviewUiState, newItem: ReviewUiState): Boolean {

            return oldItem.review?.id == newItem.review?.id
        }

        override fun areContentsTheSame(oldItem: ReviewUiState, newItem: ReviewUiState): Boolean {
            return oldItem == newItem
        }

    }
) {
    private val thumbnailMediaAdapter = ThumbnailMediaAdapter()

    interface Listener {
        fun onClickMedia(id: Int)
    }
    private var listener: Listener? = null
    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when(viewType) {
            0 -> ReviewHeaderViewHolder(ViewReviewHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                latestMediaRecyclerView.adapter = thumbnailMediaAdapter
            })
            1 -> ReviewViewHolder(ViewReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw Exception("ReviewAdapter onCreateViewHolder Exception")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position == 0) {
            (holder as ReviewHeaderViewHolder).onBind(getItem(position).header ?: return)
            thumbnailMediaAdapter.submitList(getItem(position).header?.mediaReviewThumbnail ?: return)
        } else {
            (holder as ReviewViewHolder).onBind(getItem(position).review ?: return)
        }
    }

    class ReviewHeaderViewHolder(private val viewBinding: ViewReviewHeaderBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun onBind(header: ReviewHeaderUiState) {
            viewBinding.orderTextView.text = header.order
            viewBinding.purchaseSatisfactionTextView.text = header.purchaseSatisfaction
        }
    }

    class ReviewViewHolder(private val viewBinding: ViewReviewBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun onBind(review: Review) {

            viewBinding.writerTextView.text = review.writer
            viewBinding.createdTextView.text = review.createdAt
            viewBinding.reviewDescriptionTextView.text = review.description
            viewBinding.viewPager.isVisible = false
            when(review) {
                is RecipeReview -> {

                }
                is TextReview -> {

                }
                is MediaReview -> {
                    viewBinding.viewPager.isVisible = true
//                    viewBinding.
                }
            }
        }
    }


}