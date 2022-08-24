package com.example.kurlyview.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kurlyview.data.ReviewRepository
import com.example.kurlyview.domain.Product
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product

    init {
        getProduct()
    }

    private fun getProduct() {
        viewModelScope.launch {
            ReviewRepository.getProduct(1).collect {
                _product.value = it
            }
        }
    }
}