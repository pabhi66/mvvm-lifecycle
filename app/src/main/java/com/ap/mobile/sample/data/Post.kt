package com.ap.mobile.sample.data

import com.google.gson.annotations.SerializedName

/**
 *
 * class information...
 */
data class Post(
        @field:SerializedName("userId")
        val userId: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("body")
        val body: String? = null
)