package com.example.final_codemunity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class signup_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_screen)

        val createAccnt = findViewById<Button>(R.id.btnCreateAccount)
        val fName = findViewById<TextView>(R.id.txtFName)
        val lName = findViewById<TextView>(R.id.txtLName)
        val password = findViewById<TextView>(R.id.txtPassword)
        val passwordCon = findViewById<TextView>(R.id.txtConPass)
        val email = findViewById<TextView>(R.id.txtEmail)

        createAccnt.setOnClickListener{
            if(fName.text.toString().isEmpty() || lName.text.toString().isEmpty()){
                Toast.makeText(applicationContext, getString(R.string.nameError), Toast.LENGTH_LONG).show()
            } else if (email.text.toString().isEmpty()){
                Toast.makeText(applicationContext, getString(R.string.emailError), Toast.LENGTH_LONG).show()
            }else if (password.text.toString() != passwordCon.text.toString() || password.text.toString().isEmpty()){
                Toast.makeText(applicationContext, getString(R.string.passwordError), Toast.LENGTH_LONG).show()
            }else {
                val intent = Intent(this,edit_account::class.java)
                intent.putExtra("fName", fName.text.toString())
                intent.putExtra("lName", lName.text.toString())
                startActivity(intent)
            }
        }
    }
}