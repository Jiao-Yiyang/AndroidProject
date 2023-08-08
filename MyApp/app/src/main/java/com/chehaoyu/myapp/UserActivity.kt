package com.chehaoyu.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val newsButton = findViewById<Button>(R.id.news_button)
        var buttonEdit = findViewById<Button>(R.id.button_edit)
        val videoButton = findViewById<Button>(R.id.video_button)
        val whetherButton = findViewById<Button>(R.id.weather_button)
        val loginButton = findViewById<Button>(R.id.button_logout)
        buttonEdit.setOnClickListener {
            val intent = Intent(this, EditInfoActivity::class.java)
            intent.putExtra("username", LoginActivity.currentUsername)
            startActivity(intent)
        }
        // 获取当前用户的信息
        val currentUsername = LoginActivity.currentUsername
        val textViewUserName = findViewById<TextView>(R.id.textView_username_content )
        textViewUserName.text = currentUsername
        //初始化TextView控件
        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        if (sharedPreferences.contains("$currentUsername.contact")){
                val contact = sharedPreferences.getString("$currentUsername.contact", "")
                val textViewContact = findViewById<TextView>(R.id.textView_contact_content)
                textViewContact.text = contact
        }
        if (sharedPreferences.contains("$currentUsername.gender")){
            val textViewGender = findViewById<TextView>(R.id.textView_gender_content)
            val gender = sharedPreferences.getString("$currentUsername.gender", "")
            textViewGender.text = gender
        }
        if (sharedPreferences.contains("$currentUsername.email")){
            val textViewEmail = findViewById<TextView>(R.id.textView_email_content)
            val email = sharedPreferences.getString("$currentUsername.email", "")
            textViewEmail.text = email
        }

        if (sharedPreferences.contains("$currentUsername.name")) {
            val textViewName = findViewById<TextView>(R.id.textView_name_content)
            val name = sharedPreferences.getString("$currentUsername.name", "")
            textViewName.text = name
        }


        newsButton.setOnClickListener {
            startMainActivity()
        }

        videoButton.setOnClickListener {
            startVideoActivity()
        }
        whetherButton.setOnClickListener {
            startWhetherActivity()
        }

        loginButton.setOnClickListener {
            startLoginActivity()
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
    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}