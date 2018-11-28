package com.ap.mobile.sample.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ap.mobile.sample.data.PostRepository

/**
 *
 * class information...
 */
class MainViewModelFactory(private val postRepository: PostRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(postRepository = postRepository) as T
    }
}