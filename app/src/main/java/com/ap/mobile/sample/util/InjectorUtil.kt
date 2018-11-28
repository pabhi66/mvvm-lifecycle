package com.ap.mobile.sample.util

import com.ap.mobile.sample.data.PostRepository
import com.ap.mobile.sample.data.PostService
import com.ap.mobile.sample.ui.MainViewModelFactory

/**
 *
 * class information...
 */
object InjectorUtil {

    fun provideMainViewModelFactory(): MainViewModelFactory {
        val repo = PostRepository.getInstance(PostService.instance)
        return MainViewModelFactory(repo)
    }
}