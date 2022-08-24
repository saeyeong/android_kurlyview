package com.example.kurlyview.presentation.common

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.doOnAttach
import androidx.core.view.isVisible
import com.example.kurlyview.R
import com.example.kurlyview.databinding.ToolbarKurlyviewBinding

class KurlyviewToolbar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle) {
    private val viewBinding = ToolbarKurlyviewBinding.inflate(LayoutInflater.from(context), this)

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.KulyviewToolbar)
            typedArray.getString(R.styleable.KulyviewToolbar_title)?.let { title ->
                viewBinding.titleTextView.text = title
            }
            typedArray.getBoolean(R.styleable.KulyviewToolbar_useBack, false).let { use ->
                viewBinding.backImageView.setImageResource(R.drawable.ic_baseline_arrow_back_24)
                viewBinding.backImageView.isVisible = use
            }
            typedArray.getBoolean(R.styleable.KulyviewToolbar_useClose, false).let { use ->
                viewBinding.closeImageView.setImageResource(R.drawable.ic_baseline_close_24)
                viewBinding.closeImageView.isVisible = use
            }
            typedArray.getBoolean(R.styleable.KulyviewToolbar_useCart, false).let { use ->
                viewBinding.cartImageView.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
                viewBinding.cartImageView.isVisible = use
            }
            typedArray.recycle()
        }
        doOnAttach {
            viewBinding.closeImageView.setOnClickListener {
                if (context is Activity) {
                    context.finish()
                }
            }
            viewBinding.backImageView.setOnClickListener {
                if (context is Activity) {
                    context.finish()
                }
            }
        }
    }

    fun setTitle(title: String) {
        viewBinding.titleTextView.text = title
        viewBinding.titleTextView.isVisible = true
    }
}