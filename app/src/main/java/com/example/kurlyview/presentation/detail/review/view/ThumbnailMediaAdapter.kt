package com.example.kurlyview.presentation.detail.review.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kurlyview.domain.Media
import com.example.kurlyview.presentation.utils.dpToPx

class ThumbnailMediaAdapter: ListAdapter<Media, ThumbnailMediaAdapter.MediaViewHolder>(
    object : DiffUtil.ItemCallback<Media>() {
        override fun areItemsTheSame(oldItem: Media, newItem: Media): Boolean {
            return oldItem.photoUrl == newItem.photoUrl
        }

        override fun areContentsTheSame(oldItem: Media, newItem: Media): Boolean {
            return oldItem == newItem
        }

    }
) {

    interface Listener {
        fun onClick()
    }
    private var listener: Listener? = null

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        return MediaViewHolder(ThumbnailMediaView(parent.context).apply {
            val size = context.dpToPx(100f).toInt()
            layoutParams = RecyclerView.LayoutParams(size, size).apply {
                marginEnd = context.dpToPx(10f).toInt()
            }
            this.setListener(object : ThumbnailMediaView.Listener {
                override fun onClick() {
                    listener?.onClick()
                }
            })
        })
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class MediaViewHolder(private val thumbnailMediaView: ThumbnailMediaView): RecyclerView.ViewHolder(thumbnailMediaView) {
        fun onBind(media: Media) {
            thumbnailMediaView.loadImage(media.photoUrl)
            thumbnailMediaView.setPlayImageVisible(media.videoUrl != null)
        }
    }
}