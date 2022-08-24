package com.example.kurlyview.presentation.detail.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.TerminalSeparatorType
import androidx.paging.insertFooterItem
import androidx.paging.insertHeaderItem
import com.example.kurlyview.data.ReviewRepository
import com.example.kurlyview.data.source.remote.request.ReviewOrderingDto
import com.example.kurlyview.data.source.remote.request.ReviewSearchInfoDto
import com.example.kurlyview.domain.Review
import com.example.kurlyview.domain.ReviewInfo
import com.example.kurlyview.domain.ReviewOrderingInfo
import com.example.kurlyview.presentation.detail.review.view.ReviewUiState
import com.example.kurlyview.presentation.detail.review.view.toUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ReviewViewModel: ViewModel() {

    private val _reviewUiState = MutableLiveData<ReviewUiState>()
    val reviewUiState: LiveData<ReviewUiState> get() = _reviewUiState

    lateinit var pagingDataFlow: Flow<PagingData<ReviewUiState>>

    init {
        getReviewInfo(3, "")
    }

    private fun getReviewInfo(productId: Int, order: String) {
        viewModelScope.launch {
            val test = ReviewOrderingInfo(
                    order = "",
                    info = ReviewInfo(
                        productId = productId
                    )
                )
            ReviewRepository.getReviewInfo(test).map {
                val uiState= it.toUiState()

                val reviewOrderingInfo = ReviewOrderingInfo(
                    order = order,
                    info = ReviewInfo(productId)
                )

                pagingDataFlow = ReviewRepository.getSearchReview(reviewOrderingInfo)
                    .map { pd ->
                        pd.insertHeaderItem(
                            item = uiState
                        )
                    }

                uiState
            }.collect {
                _reviewUiState.value = it
            }
        }
    }
}