package com.chehaoyu.myapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class WebActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val intent = intent
        val query = intent.getStringExtra("QUERY")
        var backButton = findViewById<Button>(R.id.button_back)
        var webView = findViewById<WebView>(R.id.web_view)
         webView.loadUrl("https://www.baidu.com/s?wd="+query)
        webView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                //使用WebView加载显示url
                view.loadUrl(url)
                //返回true
                return true
            }
        })
        backButton.setOnClickListener(View.OnClickListener {
            var intent: Intent? = null
            intent = Intent(this@WebActivity, MainActivity::class.java)
            startActivity(intent)
        })
    }
}
