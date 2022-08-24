package com.example.kurlyview.presentation.media

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kurlyview.data.ReviewRepository
import com.example.kurlyview.domain.MediaReview
import kotlinx.coroutines.launch

class MediaViewModel: ViewModel() {

    private val _review = MutableLiveData<MediaReview>()
    val review: LiveData<MediaReview> get() = _review

    fun getReview(reviewId: Int) {
        viewModelScope.launch {
            ReviewRepository.getReview(reviewId).collect { review ->
                _review.value = review as MediaReview
            }

        }
    }
}