package com.chehaoyu.myapp


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
data class Video(
    val title: String,
    val thumbnailUrl: String
)
class VideoAdapter(private val videoList: List<Video>) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videoList[position]
        Glide.with(holder.itemView.context)
            .load(video.thumbnailUrl)
            .into(holder.thumbnailView)
        holder.titleView.text = video.title
        holder.thumbnailView.setOnClickListener {
            val videoUri = Uri.parse(video.thumbnailUrl)
            val intent = Intent(Intent.ACTION_VIEW, videoUri)
            intent.setDataAndType(videoUri, "video/*")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnailView: ImageView = itemView.findViewById(R.id.thumbnail)
        val titleView: TextView = itemView.findViewById(R.id.title)
    }
}