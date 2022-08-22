package com.example.kurlyview.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Media(
    val photoUrl: String,
    val videoUrl: String?,
) : Parcelable