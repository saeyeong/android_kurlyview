package com.example.kurlyview.presentation.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.kurlyview.data.ReviewRepository
import com.example.kurlyview.domain.ReviewOrderingInfo
import com.example.kurlyview.domain.ReviewInfo
import com.example.kurlyview.domain.ReviewThumbnail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AlbumViewModel: ViewModel() {

    lateinit var pagingDataFlow: Flow<PagingData<ReviewThumbnail>>

    private val _reviewOrderingInfo = MutableLiveData<ReviewOrderingInfo>()
    val reviewOrderingInfo: LiveData<ReviewOrderingInfo> get() = _reviewOrderingInfo

    fun setProductId(productId: Int) {
        _reviewOrderingInfo.value = ReviewOrderingInfo(
            info = ReviewInfo(productId)
        )
    }

    fun getMedia(reviewOrderingInfo: ReviewOrderingInfo) {
        viewModelScope.launch {
            pagingDataFlow = ReviewRepository.getMediaReviews(reviewOrderingInfo)
        }
    }

}