package com.ap.mobile.sample.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ap.mobile.sample.data.Post
import com.ap.mobile.sample.databinding.ItemPostBinding

/**
 *
 * class information...
 */
class PostAdapter(
        private val posts: List<Post>,
        private val listener: (Post) -> Unit
): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {

        fun onBind(post: Post, listener: (Post) -> Unit) = with(binding.root) {
            binding.post = post
            setOnClickListener { listener(post) }
        }
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.onBind(posts[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater)
        return PostViewHolder(binding)
    }
}