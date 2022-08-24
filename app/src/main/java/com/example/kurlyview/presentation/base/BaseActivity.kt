package com.example.kurlyview.presentation.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VB: ViewBinding, VM: ViewModel>: AppCompatActivity() {

    protected val viewBinding: VB by lazy { inflateViewBinding() }
    protected lateinit var viewModel: VM

    abstract fun inflateViewBinding(): VB

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val parameterizedType = javaClass.genericSuperclass as? ParameterizedType

        val vmClass = parameterizedType?.actualTypeArguments?.getOrNull(1) as? Class<VM>

        vmClass?.let {
            viewModel = ViewModelProvider(this).get(it)
        } ?: run {
            finish()
            return
        }
    }
}