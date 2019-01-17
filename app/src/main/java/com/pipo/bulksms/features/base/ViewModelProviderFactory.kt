package com.pipo.bible.features.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by Philip on 28/12/2017.
 *
 *
 * A provider factory that persists ViewModels[ViewModel].
 * Used if the viewmodel has a parameterized constructor.
 */
class ViewModelProviderFactory<V : ViewModel>(private val viewModel: V) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel.javaClass)) return viewModel as T
        throw IllegalArgumentException("Unknown class name")
    }

}