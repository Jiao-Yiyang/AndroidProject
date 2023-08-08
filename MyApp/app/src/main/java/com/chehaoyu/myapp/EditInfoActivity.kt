package com.chehaoyu.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditInfoActivity: AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private var currentUsername: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editinfo)
        var button_save = findViewById<Button>(R.id.button_save)
        var editTextName = findViewById<EditText>(R.id.editText_name)
        val editTextContact = findViewById<EditText>(R.id.editText_contact)
        val editTextGender = findViewById<EditText>(R.id.editText_gender)
        val editTextEmail = findViewById<EditText>(R.id.editText_email)
        currentUsername = intent.getStringExtra("username")

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("$currentUsername.name", "")
        val contact = sharedPreferences.getString("$currentUsername.contact", "")
        val gender = sharedPreferences.getString("$currentUsername.gender", "")
        val email = sharedPreferences.getString("$currentUsername.email", "")

        editTextName.setText(name)
        editTextContact.setText(contact)
        editTextGender.setText(gender)
        editTextEmail.setText(email)

        button_save.setOnClickListener {
            val name = editTextName.text.toString()
            val contact = editTextContact.text.toString()
            val gender = editTextGender.text.toString()
            val email = editTextEmail.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("$currentUsername.name", name)
            editor.putString("$currentUsername.contact", contact)
            editor.putString("$currentUsername.gender", gender)
            editor.putString("$currentUsername.email", email)
            editor.apply()

            startUserActivity()
        }
    }
    private fun startUserActivity() {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
        finish()
    }
}