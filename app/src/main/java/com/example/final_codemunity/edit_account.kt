package com.example.final_codemunity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class edit_account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_account)

        val extras = intent.extras

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)

        val firstName = findViewById<TextView>(R.id.firstNameId)
        val lastName = findViewById<TextView>(R.id.lastNameId)

        val bio = findViewById<TextView>(R.id.bioId)
        val traits = findViewById<TextView>(R.id.traitsId)
        val skills = findViewById<TextView>(R.id.skillsId)
        val experience = findViewById<TextView>(R.id.experiId)

        val bioBtn = findViewById<Button>(R.id.confirmBio)
        val skillBtn = findViewById<Button>(R.id.skillsBtn)
        val traitBtn = findViewById<Button>(R.id.traitBtn)
        val experiBtn = findViewById<Button>(R.id.experiBtn)

        if (extras != null) {
            val fName = extras.getString("fName")
            val lName = extras.getString("lName")

            firstName.text = fName
            lastName.text = lName
        }

        bioBtn.setOnClickListener(){
            bio.setFocusable(false)
            Toast.makeText(this@edit_account, "Bio updated!", Toast.LENGTH_SHORT).show()
        }

        skillBtn.setOnClickListener(){
            skills.setFocusable(false)
            Toast.makeText(this@edit_account, "Skills updated!", Toast.LENGTH_SHORT).show()
        }

        experiBtn.setOnClickListener(){
            experience.setFocusable(false)
            Toast.makeText(this@edit_account, "Experience updated!", Toast.LENGTH_SHORT).show()
        }

        traitBtn.setOnClickListener(){
            traits.setFocusable(false)
            Toast.makeText(this@edit_account, "Traits updated!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.navigation -> {
            val intent = Intent(this,timeline_screen::class.java)
            val intent2 = Intent(this,MainActivity::class.java)
            val nav = findViewById<View>(R.id.navigation)
            val popupMenu = PopupMenu(this, nav)
            popupMenu.menuInflater.inflate(R.menu.pages_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.timelineNav ->
                        startActivity(intent)
                    R.id.accountNav ->
                        Toast.makeText(this@edit_account, "Already on Edit Account", Toast.LENGTH_SHORT).show()
                    R.id.logoutNav ->
                        startActivity(intent2)
                }
                true
            })
            popupMenu.show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}