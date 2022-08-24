package com.example.kurlyview.presentation.album.view

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kurlyview.domain.ReviewThumbnail
import com.example.kurlyview.domain.ReviewThumbnails
import com.example.kurlyview.presentation.detail.review.view.ThumbnailMediaView
import com.example.kurlyview.presentation.utils.dpToPx
import com.google.android.flexbox.FlexboxLayoutManager

class AlbumAdapter : PagingDataAdapter<ReviewThumbnail, AlbumAdapter.AlbumViewHolder>(
    object : DiffUtil.ItemCallback<ReviewThumbnail>() {
        override fun areItemsTheSame(oldItem: ReviewThumbnail, newItem: ReviewThumbnail): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ReviewThumbnail, newItem: ReviewThumbnail): Boolean {
            return oldItem == newItem
        }

    }
) {

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {

        holder.onBind(getItem(position) ?: return)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(ThumbnailMediaView(parent.context).apply {
            val size = this.context.dpToPx(80f).toInt()
            layoutParams = FlexboxLayoutManager.LayoutParams(size, size)
        })
    }

    class AlbumViewHolder(private val thumbnailMediaView: ThumbnailMediaView): RecyclerView.ViewHolder(thumbnailMediaView) {
        fun onBind(reviewThumbnail: ReviewThumbnail) {
            val isVideo = reviewThumbnail.thumbnail.isNotEmpty()
            val url = reviewThumbnail.thumbnail.takeIf { isVideo } ?: reviewThumbnail.url
            thumbnailMediaView.loadImage(url)
            thumbnailMediaView.setPlayImageVisible(isVideo)
        }
    }
}