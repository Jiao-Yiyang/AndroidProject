package com.chehaoyu.myapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsViewHolder :RecyclerView.ViewHolder {
    var ivCover: ImageView
        private set
    /** 标题 */
    var tvTitle: TextView
        private set
    /** 内容 */
    var tvContent: TextView
        private set


    constructor(view: View) : super(view) {
        ivCover = view.findViewById(R.id.cover)
        tvTitle = view.findViewById(R.id.textView)
        tvContent = view.findViewById(R.id.textView2)
    }
}