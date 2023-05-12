package com.example.final_codemunity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUp = findViewById<Button>(R.id.signUpBtn)

        signUp.setOnClickListener{
            val intent = Intent(this,signup_screen::class.java)
            startActivity(intent)
        }
    }

}