package com.example.kurlyview.presentation.media.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kurlyview.domain.MediaReview

class MediaAdapter: ListAdapter<MediaReview, MediaAdapter.MediaViewHolder>(
    object : DiffUtil.ItemCallback<MediaReview>() {
        override fun areItemsTheSame(oldItem: MediaReview, newItem: MediaReview): Boolean {
            return oldItem.content.photoUrl == newItem.content.photoUrl
        }

        override fun areContentsTheSame(oldItem: MediaReview, newItem: MediaReview): Boolean {
            return oldItem == newItem
        }

    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        return MediaViewHolder(MediaView(parent.context))
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class MediaViewHolder(private val mediaView: MediaView): RecyclerView.ViewHolder(mediaView) {
        fun onBind(mediaReview: MediaReview) {
            mediaView.loadImage(mediaReview.content.photoUrl)
            mediaView.setPlayImageVisible(mediaReview.content.videoUrl != null)
            mediaView.setListener(object : MediaView.Listener {
                override fun playVideo() {

                }
            })
        }
    }
}