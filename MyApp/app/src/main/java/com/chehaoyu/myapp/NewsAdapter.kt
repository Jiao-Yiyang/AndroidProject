package com.chehaoyu.myapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NewsAdapter(items: List<ItemBean>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private val mItems: List<ItemBean>

    init {
        mItems = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycleview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: ItemBean = mItems[position]
        item.coverUrl?.let { holder.imageView.setImageResource(it) }
        holder.textView1.setText(item.title)
        holder.textView2.setText(item.content)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView1: TextView
        var textView2: TextView

        init {
            imageView = itemView.findViewById<ImageView>(R.id.cover)
            textView1 = itemView.findViewById<TextView>(R.id.textView)
            textView2 = itemView.findViewById<TextView>(R.id.textView2)
        }
    }
}