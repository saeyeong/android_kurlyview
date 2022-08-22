package com.example.kurlyview.presentation.media.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kurlyview.domain.Media

class MediaAdapter: ListAdapter<Media, MediaAdapter.MediaViewHolder>(
    object : DiffUtil.ItemCallback<Media>() {
        override fun areItemsTheSame(oldItem: Media, newItem: Media): Boolean {
            return oldItem.photoUrl == newItem.photoUrl
        }

        override fun areContentsTheSame(oldItem: Media, newItem: Media): Boolean {
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
        fun onBind(media: Media) {
            mediaView.loadImage(media.photoUrl)
            mediaView.setPlayImageVisible(media.videoUrl != null)
            mediaView.setListener(object : MediaView.Listener {
                override fun playVideo() {

                }
            })
        }
    }
}