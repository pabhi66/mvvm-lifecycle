package com.ap.mobile.sample.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 *
 * class information...
 */
interface PostService {

    companion object {
        val instance: PostService by lazy {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            retrofit.create(PostService::class.java)
        }
    }

    @GET("posts")
    fun getPostList(): Call<List<Post>>
}