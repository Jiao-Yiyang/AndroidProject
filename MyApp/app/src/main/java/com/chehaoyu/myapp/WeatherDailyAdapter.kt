package com.chehaoyu.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WeatherDailyAdapter(items: List<WeatherDaily_item>) :
    RecyclerView.Adapter<WeatherDailyAdapter.ViewHolder>() {
    private val mItems: List<WeatherDaily_item>

    init {
        mItems = items
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: WeatherDaily_item = mItems[position]
        holder.time.text = item.time
        holder.weatherIcon.setImageResource(item.weatherIcon)
        holder.temperature.text = item.temperature
        holder.weather.text = item.weather
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_daily_item, parent, false)
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
        var time: TextView
        var weatherIcon: ImageView
        var temperature: TextView
        var weather: TextView

        init {
            time = itemView.findViewById<TextView>(R.id.time)
            weatherIcon = itemView.findViewById<ImageView>(R.id.weatherIcon)
            temperature = itemView.findViewById<TextView>(R.id.temperature)
            weather = itemView.findViewById<TextView>(R.id.weather)
        }
    }
}