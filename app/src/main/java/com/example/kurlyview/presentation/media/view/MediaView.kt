package com.example.kurlyview.presentation.media.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.kurlyview.databinding.ViewMediaBinding

class MediaView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle) {
    private val viewBinding = ViewMediaBinding.inflate(LayoutInflater.from(context), this)

    interface Listener {
        fun playVideo()
    }
    private var listener: Listener? = null

    init {
        viewBinding.reviewImageView.setOnClickListener {
            listener?.playVideo()
        }
    }

    fun loadImage(url: String) {
        Glide.with(context)
            .load(url)
            .into(viewBinding.reviewImageView)
    }

    fun setPlayImageVisible(visible: Boolean) {
        viewBinding.playImageView.isVisible = visible
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }
}