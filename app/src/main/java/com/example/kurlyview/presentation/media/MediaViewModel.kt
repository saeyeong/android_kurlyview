package com.example.kurlyview.presentation.media

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kurlyview.data.ReviewRepository
import com.example.kurlyview.domain.MediaReview
import kotlinx.coroutines.launch

class MediaViewModel: ViewModel() {

    private val _review = MutableLiveData<List<MediaReview>>()
    val review: LiveData<List<MediaReview>> get() = _review

    fun getReview(reviewId: Int) {
        viewModelScope.launch {
            ReviewRepository.getReview(reviewId).collect { reviews ->
                _review.value = reviews.map { it as MediaReview }
            }

        }
    }
}