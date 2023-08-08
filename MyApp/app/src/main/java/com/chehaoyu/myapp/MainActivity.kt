package com.chehaoyu.myapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val whetherButton = findViewById<Button>(R.id.weather_button)
        whetherButton.setOnClickListener {
            startWhetherActivity()
        }

        val videoButton = findViewById<Button>(R.id.video_button)
        videoButton.setOnClickListener {
            startVideoActivity()
        }
        val userButton = findViewById<Button>(R.id.user_button)
        userButton.setOnClickListener {
            startUserActivity()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = NewsAdapter(createDemoDate())
        recyclerView.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val searchInput = findViewById<EditText>(R.id.search_input)
        val searchButton = findViewById<ImageButton>(R.id.search_button)

        searchButton.setOnClickListener {
            val query = searchInput.text.toString()
            val intent = Intent(this, WebActivity::class.java)
            intent.putExtra("QUERY", query)
            startActivity(intent)
        }

    }


    private fun startWhetherActivity() {
        val intent = Intent(this, WeatherActivity::class.java)
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


private fun createDemoDate(): ArrayList<ItemBean> {

    val list = ArrayList<ItemBean>()
    val titles = arrayOf(
        "新冠疫苗接种进入第二年，专家呼吁加强疫苗接种宣传",
        "美国宣布对中国等多国实施新制裁",
        "研究称全球气温创下有记录以来的新高",
        "世界杯预选赛：中国队客场1比0战胜叙利亚队",
        "亚马逊创始人贝索斯成功飞行太空",
        "中国汽车市场逐步恢复，新能源汽车销量创新高",
        "美国国会通过1.2万亿美元基础设施投资计划",
        "中国将建设世界最大的空中列车",
        "欧盟宣布将禁止单次使用塑料制品",
        "日本东京奥运会开幕式盛大举行",
        "伊朗宣布恢复核活动",
        "特斯拉发布自动驾驶新功能",
        "澳大利亚宣布将对谷歌和脸书等科技公司征税",
        "非洲多国爆发埃博拉病毒疫情",
        "瑞士将举行全民公投，决定是否允许同性婚姻合法化",
        "英国女王伊丽莎白二世庆祝即位70周年"
    )

    val contents = arrayOf(
        "自新冠疫苗接种工作开展以来，已经有超过10亿人次接种疫苗。但是，由于疫苗接种率不均，疫情形势仍然严峻。专家认为，应该加强疫苗接种宣传，让更多的人了解疫苗的重要性。",
        "美国政府宣布对中国、俄罗斯、朝鲜等多个国家实施新制裁，限制它们在美国市场的活动。此举引发了国际社会的广泛关注和质疑。",
        "一项最新研究发现，全球气温正在不断上升，已经创下有记录以来的新高。科学家警告称，气温上升可能会导致海平面上升、极端天气事件增加等问题。",
        "在2022年世界杯预选赛亚洲区40强赛中，中国队客场1比0战胜叙利亚队，取得了开门红。这场比赛也成为了中国队在这个赛季的首场胜利。",
        "亚马逊创始人贝索斯成功飞行太空，成为了第二位自费进入太空的亿万富翁。这项壮举引发了全球范围内的关注和热议。",
        "中国汽车市场逐步恢复，新能源汽车的销量也创下了新高。专家认为，这说明了中国汽车市场的潜力和活力。",
        "美国国会通过了一项价值1.2万亿美元的基础设施投资计划，旨在改善国家的道路、桥梁、水道和网络等基础设施，这是美国历史上规模最大的一项基础设施投资计划。",
        "中国计划建设世界最大的空中列车，该列车可在城市之间高速行驶，最高时速可达600公里。该项目预计将于2025年开始建设。",
        "欧盟宣布将禁止单次使用塑料制品，该禁令将涵盖一次性塑料餐具、吸管、棉花棒等。欧盟希望这一举措能够减少海洋垃圾的产生。",
        "2021年东京奥运会开幕式在东京国立竞技场举行，来自世界各地的运动员齐聚一堂。这也是日本首次举办夏季奥运会。",
        "伊朗宣布恢复核活动，并开始生产浓度达到60%的铀，这是伊朗核计划中的又一重大进展。此举引发了国际社会的广泛关注和担忧。",
        "特斯拉发布了一项新的自动驾驶功能，该功能使得特斯拉车辆可以自动停车、上下坡、变道等。这项技术被认为是自动驾驶技术的重要进展。",
        "澳大利亚宣布将对谷歌和脸书等科技公司征税，以增加政府财政收入。这项税收将主要针对在澳大利亚进行数字广告业务的公司。",
        "非洲多国爆发埃博拉病毒疫情，该病毒已经导致数百人死亡。世界卫生组织正在积极应对这一疫情。",
        "瑞士将举行全民公投，决定是否允许同性婚姻合法化。该公投引发了瑞士社会的激烈讨论。",
        "英国女王伊丽莎白二世庆祝即位70周年，这标志着她已经成为英国历史上在位时间最长的君主。英国政府将举行多项庆祝活动来纪念这一历史时刻。"
    )

    for (i in 0 until titles.size) {
        val item = ItemBean(R.drawable.news_icon, titles[i], contents[i])
        // 0 is used as a placeholder for the image resource
        list.add(item)
    }

    return list
}
