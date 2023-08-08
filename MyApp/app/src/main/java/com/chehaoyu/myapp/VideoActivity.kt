package com.chehaoyu.myapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VideoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: VideoAdapter
    private lateinit var videoList: MutableList<Video>
    private var isLoading = false

    private var currentPage = 1
    private val totalPage = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val newsButton = findViewById<Button>(R.id.news_button)
        newsButton.setOnClickListener {
            startMainActivity()
        }
        val userButton = findViewById<Button>(R.id.user_button)
        userButton.setOnClickListener {
            startUserActivity()
        }
        val whetherButton = findViewById<Button>(R.id.weather_button)
        whetherButton.setOnClickListener {
            startWhetherActivity()
        }

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)

        videoList = mutableListOf()
        adapter = VideoAdapter(videoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (!isLoading) {
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                    val totalItemCount = layoutManager.itemCount

                    if (lastVisibleItemPosition == totalItemCount - 1 && currentPage < totalPage) {
                        currentPage++
                        loadMoreVideos()
                    }
                }
            }
        })

        loadMoreVideos()
    }

    private fun startWhetherActivity() {
        val intent = Intent(this, WeatherActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun startUserActivity() {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun loadMoreVideos() {
        isLoading = true
        progressBar.visibility = View.VISIBLE
        val newVideos = mutableListOf<Video>()
        var video = Video("2020 Lakers","https://box.nju.edu.cn/f/441daafc27a440db9058/?dl=1")
        newVideos.add(video)
        video = Video("I got smoke","https://box.nju.edu.cn/f/9d53166be4334abdb248/?dl=1")
        newVideos.add(video)
        video = Video("interview","https://box.nju.edu.cn/f/cdfae79b4ddb45a2913b/?dl=1")
        newVideos.add(video)
        video = Video("LeBron James","https://box.nju.edu.cn/f/14af5748dfb04f12b293/?dl=1")
        newVideos.add(video)
        video = Video("I'm DianLao","https://box.nju.edu.cn/f/9ef152f1a28a4a71aa37/?dl=1")
        newVideos.add(video)
        videoList.addAll(newVideos)

        // 通知 RecyclerView 数据集发生变化，以便更新列表
        adapter.notifyDataSetChanged()

        // 将 isLoading 标志设置为 false，并隐藏 ProgressBar
        isLoading = false
        progressBar.visibility = View.GONE
    }
}
