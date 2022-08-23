package com.example.kurlyview.presentation.detail.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kurlyview.data.ReviewRepository
import kotlinx.coroutines.launch

class ReviewViewModel: ViewModel() {

    init {
        getReview()
    }

    private fun getReview() {
        viewModelScope.launch {
            ReviewRepository.getReview(1).collect {

            }
        }
    }
}