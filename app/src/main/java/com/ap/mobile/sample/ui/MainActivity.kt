package com.ap.mobile.sample.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ap.mobile.sample.R
import com.ap.mobile.sample.ui.adapter.PostAdapter
import com.ap.mobile.sample.util.InjectorUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    private fun setup() {
        val factory = InjectorUtil.provideMainViewModelFactory()
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel::class.java)
        setupPostList()
    }

    private fun setupPostList() {
        viewModel.getPosts().observe(this, Observer {
            if(it != null)
                rv_main_post_list.adapter = PostAdapter(it) {
                    Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
                }
        })
    }
}
