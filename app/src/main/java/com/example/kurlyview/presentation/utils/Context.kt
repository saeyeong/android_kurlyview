package com.example.kurlyview.presentation.utils

import android.content.Context
import android.util.TypedValue


fun Context.dpToPx(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
}