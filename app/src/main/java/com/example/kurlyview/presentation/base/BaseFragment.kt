package com.example.kurlyview.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel>: Fragment() {
    lateinit var viewBinding: VB
    protected lateinit var viewModel: VM

    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = inflateViewBinding(inflater, container)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parameterizedType = javaClass.genericSuperclass as? ParameterizedType

        val vmClass = parameterizedType?.actualTypeArguments?.getOrNull(1) as? Class<VM>

        vmClass?.let {
            viewModel = ViewModelProvider(this).get(it)
        } ?: run {
            activity?.finish()
            return
        }
    }
}