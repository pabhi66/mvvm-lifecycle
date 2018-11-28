package com.ap.mobile.sample.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *
 * class information...
 */
class PostRepository private constructor(private val postService: PostService) {

    private val posts = MutableLiveData<List<Post>>()

    companion object {
        @Volatile private var instance: PostRepository? = null

        fun getInstance(postService: PostService) = instance ?: synchronized(this) {
            instance ?: PostRepository(postService).also {
                instance = it
            }
        }
    }

    fun getPostList(): LiveData<List<Post>> {
        postService.getPostList().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                if(response != null && response.isSuccessful) {
                    posts.value = response.body()
                }
            }
        })
        return posts
    }
}