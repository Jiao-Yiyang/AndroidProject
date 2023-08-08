package com.chehaoyu.myapp


import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val newsButton = findViewById<Button>(R.id.news_button)
        newsButton.setOnClickListener {
            startMainActivity()
        }
        val videoButton = findViewById<Button>(R.id.video_button)
        videoButton.setOnClickListener {
            startVideoActivity()
        }
        val userButton = findViewById<Button>(R.id.user_button)
        userButton.setOnClickListener {
            startUserActivity()
        }



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView1)
        val adapter = WeatherAdapter(createNextDate())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val recyclerView1 = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter1 = WeatherDailyAdapter(createDailyDate())
        recyclerView1.adapter = adapter1
        recyclerView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
    private fun createDailyDate(): ArrayList<WeatherDaily_item> {
        // 创建未来7天的每日天气预报的RecyclerView的数据源和适配器
        val weatherDailyItemList = ArrayList<WeatherDaily_item>()

        val weatherIcons = listOf(
            R.drawable.ic_clear_day,
            R.drawable.ic_clear_day,
            R.drawable.ic_partly_cloud_day,
            R.drawable.ic_cloudy,
            R.drawable.ic_light_rain,
            R.drawable.ic_partly_cloud_day,
            R.drawable.ic_partly_cloud_day,
            R.drawable.ic_partly_cloud_day,
        )

        val times = listOf(
            "上午8点", "上午9点", "上午10点", "上午11点", "下午12点", "下午1点", "下午2点", "下午3点",
            "下午4点", "下午5点", "下午6点", "下午7点", "下午8点", "下午9点", "下午10点"
        )

        val temperatures = listOf("31℃", "33℃", "35℃","35℃","36℃","35℃","37℃","37℃","35℃","33℃","31℃","29℃","28℃")
        val weathers = listOf("晴\n", "晴\n", "多云\n", "阴\n", "小雨\n", "多云\n" ,"多云\n" ,"多云\n")

        for (i in 0..12) {
            val weatherIcon = weatherIcons[i % weatherIcons.size]
            val time = times[i % times.size]
            val temperature = temperatures[i % temperatures.size]
            val weather = weathers[i % weathers.size]
            val weatherDailyItem = WeatherDaily_item(time, temperature, weatherIcon, "$weather")
            weatherDailyItemList.add(weatherDailyItem)
        }

        return weatherDailyItemList
    }

    private fun createNextDate(): ArrayList<Weather_item> {
        // 创建15天的天气预报的RecyclerView的数据源和适配器
        val weather_item_daysList = ArrayList<Weather_item>()

        val weatherIcons = listOf(
            R.drawable.ic_clear_day,
            R.drawable.ic_cloudy,
            R.drawable.ic_cloudy,
            R.drawable.ic_cloudy,
            R.drawable.ic_light_rain,
            R.drawable.ic_moderate_rain,
            R.drawable.ic_heavy_rain,
            R.drawable.ic_storm_rain,
        )

        val dates = listOf(
            "07/26", "07/27", "07/28", "07/29", "07/30", "07/31", "08/01",
            "08/02", "08/03", "08/04", "08/05", "08/06", "08/07", "08/08", "08/09"
        )

        val temperatures = listOf("27~32℃", "28~33℃", "29~35℃")
        val windForces = listOf("3-4级", "4-5级", "5-6级")
        val windDirections = listOf("东南风", "南风", "西南风")

        var index = 0
        for (i in 1..15) {
            val weatherIcon = weatherIcons[i % weatherIcons.size]
            val date = dates[index % dates.size]
            val temperature = temperatures[index % temperatures.size]
            val windForce = windForces[index % windForces.size]
            val windDirection = windDirections[index % windDirections.size]

            val weatherItem = Weather_item(date, windForce, temperature, windDirection, weatherIcon)
            weather_item_daysList.add(weatherItem)

            if (i % 3 == 0) {
                index++
            }
        }

        return weather_item_daysList
    }


    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startVideoActivity() {
        val intent = Intent(this, VideoActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun startUserActivity() {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
        finish()
    }

}