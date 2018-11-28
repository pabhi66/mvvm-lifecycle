package com.ap.mobile.sample.ui

import android.arch.lifecycle.ViewModel
import com.ap.mobile.sample.data.PostRepository

/**
 *
 * class information...
 */
class MainViewModel(private val postRepository: PostRepository): ViewModel() {

    fun getPosts() = postRepository.getPostList()
}