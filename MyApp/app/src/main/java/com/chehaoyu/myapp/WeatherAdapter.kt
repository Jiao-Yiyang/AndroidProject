package com.chehaoyu.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WeatherAdapter(items: List<Weather_item>) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    private val mItems: List<Weather_item>

    init {
        mItems = items
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Weather_item = mItems[position]
        holder.date.text = item.date
        holder.weatherIcon.setImageResource(item.weatherIcon1)
        holder.temperature.text = item.temperature1
        holder.windDirection.text = item.wind_direction
        holder.windForce.text = item.wind_force
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.weatherlist_item, parent, false)
        view.layoutParams = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT,
            RecyclerView.LayoutParams.MATCH_PARENT
        )
        return ViewHolder(view)
    }



    override fun getItemCount(): Int {
        return mItems.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date: TextView
        var weatherIcon: ImageView
        var temperature: TextView
        var windDirection: TextView
        var windForce: TextView

        init {
            date = itemView.findViewById<TextView>(R.id.date)
            weatherIcon = itemView.findViewById<ImageView>(R.id.weatherIcon1)
            temperature = itemView.findViewById<TextView>(R.id.temperature1)
            windDirection = itemView.findViewById<TextView>(R.id.wind_direction)
            windForce = itemView.findViewById<TextView>(R.id.wind_force)
        }
    }
}