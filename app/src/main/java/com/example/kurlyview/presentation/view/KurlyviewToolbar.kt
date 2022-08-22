package com.example.kurlyview.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.kurlyview.databinding.ToolbarKurlyviewBinding

class KurlyviewToolbar @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyle: Int = 0) : LinearLayoutCompat(context, attr, defStyle) {
    private val viewBinding = ToolbarKurlyviewBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
    }
}