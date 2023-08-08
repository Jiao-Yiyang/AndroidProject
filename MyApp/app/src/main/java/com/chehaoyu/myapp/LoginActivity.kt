package com.chehaoyu.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    companion object {
        var currentUsername: String = ""
    }
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUsername = findViewById(R.id.editText_username)
        editTextPassword = findViewById(R.id.editText_password)
        buttonLogin = findViewById(R.id.button_login)
        buttonRegister = findViewById(R.id.button_register)

        sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            val savedPassword = sharedPreferences.getString(username, null)

            if (savedPassword != null && savedPassword == password) {
                showToast("Login succeeded")
                currentUsername = username
                startMainActivity()
            } else {
                showToast("Login failed")
            }
        }

        buttonRegister.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val savedPassword = sharedPreferences.getString(username, null)
            if(savedPassword!=null){
                showToast("Registration failed, user already exist")
            }else if( username==""){
                showToast("Registration failed, username can't blank")
            }else if( password ==""){
                showToast("Registration failed, password can't blank")
            } else{
                val editor = sharedPreferences.edit()
                editor.putString(username, password)
                editor.apply()
                showToast("Registration succeeded")
            }

        }
    }
    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun showToast(mes:String ){
        val toast = Toast.makeText(this, mes, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0) // 将Toast显示在屏幕中央
        val toastLayout = layoutInflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.custom_toast_container))
        val textView = toastLayout.findViewById<TextView>(R.id.content1)
        textView.text = mes
        toast.view = toastLayout
        toast.show()
    }
}