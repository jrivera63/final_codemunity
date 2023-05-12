package com.example.final_codemunity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class timeline_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeline_screen)

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)

        val likeBtn1 = findViewById<ImageView>(R.id.likeButton1)
        val dislikeBtn1 = findViewById<ImageView>(R.id.dislikeButton1)
        val shareBtn1 = findViewById<ImageView>(R.id.shareButton1)
        var liked1 = false
        var disliked1 = false

        val likeBtn2 = findViewById<ImageView>(R.id.likeButton2)
        val dislikeBtn2 = findViewById<ImageView>(R.id.dislikeButton2)
        val shareBtn2 = findViewById<ImageView>(R.id.shareButton2)
        var liked2 = false
        var disliked2 = false

        shareBtn1.setOnClickListener() {
            val popupMenu = PopupMenu(this, shareBtn1)
            popupMenu.menuInflater.inflate(R.menu.media_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.facebook ->
                        Toast.makeText(this@timeline_screen, "Successfully shared on Facebook ", Toast.LENGTH_SHORT).show()
                    R.id.insta ->
                        Toast.makeText(this@timeline_screen, "Successfully shared on Instagram ", Toast.LENGTH_SHORT).show()
                    R.id.twitter ->
                        Toast.makeText(this@timeline_screen, "Successfully shared on Twitter ", Toast.LENGTH_SHORT).show()
                    R.id.pinterest ->
                        Toast.makeText(this@timeline_screen, "Successfully shared on Pinterest ", Toast.LENGTH_SHORT).show()
                }
                true
            })
            popupMenu.show()
        }

        shareBtn2.setOnClickListener() {
            val popupMenu = PopupMenu(this, shareBtn2)
            popupMenu.menuInflater.inflate(R.menu.media_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.facebook ->
                        Toast.makeText(this@timeline_screen, "Successfully shared on Facebook ", Toast.LENGTH_SHORT).show()
                    R.id.insta ->
                        Toast.makeText(this@timeline_screen, "Successfully shared on Instagram ", Toast.LENGTH_SHORT).show()
                    R.id.twitter ->
                        Toast.makeText(this@timeline_screen, "Successfully shared on Twitter ", Toast.LENGTH_SHORT).show()
                    R.id.pinterest ->
                        Toast.makeText(this@timeline_screen, "Successfully shared on Pinterest ", Toast.LENGTH_SHORT).show()
                }
                true
            })
            popupMenu.show()
        }



        fun like1(){
            likeBtn1.setImageResource(R.drawable.blue_like)
            liked1 = true
        }

        fun like2(){
            likeBtn2.setImageResource(R.drawable.blue_like)
            liked2 = true
        }

        fun removeLike1(){
            likeBtn1.setImageResource(R.drawable.black_like)
            liked1 = false
        }

        fun removeLike2(){
            likeBtn2.setImageResource(R.drawable.black_like)
            liked2 = false
        }

        fun dislike1(){
            dislikeBtn1.setImageResource(R.drawable.red_dislike)
            disliked1 = true
        }

        fun dislike2(){
            dislikeBtn2.setImageResource(R.drawable.red_dislike)
            disliked2 = true
        }

        fun removeDislike1(){
            dislikeBtn1.setImageResource(R.drawable.black_dislike)
            disliked1 = false
        }

        fun removeDislike2(){
            dislikeBtn2.setImageResource(R.drawable.black_dislike)
            disliked2 = false
        }

        likeBtn1.setOnClickListener(){
            if (!liked1){
               like1()
                Toast.makeText(applicationContext, "Liked", Toast.LENGTH_SHORT).show()
                removeDislike1()
            } else {
                removeLike1()
                Toast.makeText(applicationContext, "Like Removed", Toast.LENGTH_SHORT).show()
            }
        }

        likeBtn2.setOnClickListener(){
            if (!liked2){
                like2()
                Toast.makeText(applicationContext, "Liked", Toast.LENGTH_SHORT).show()
                removeDislike2()
            } else {
                removeLike2()
                Toast.makeText(applicationContext, "Like Removed", Toast.LENGTH_SHORT).show()
            }
        }

        dislikeBtn1.setOnClickListener(){
            if (!disliked1){
                dislike1()
                Toast.makeText(applicationContext, "Disliked", Toast.LENGTH_SHORT).show()
                removeLike1()
            } else {
                removeDislike1()
                Toast.makeText(applicationContext, "Dislike Removed", Toast.LENGTH_SHORT).show()
            }
        }

        dislikeBtn2.setOnClickListener(){
            if (!disliked2){
                dislike2()
                Toast.makeText(applicationContext, "Disliked", Toast.LENGTH_SHORT).show()
                removeLike2()
            } else {
                removeDislike2()
                Toast.makeText(applicationContext, "Dislike Removed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.navigation -> {
            val intent = Intent(this,edit_account::class.java)
            val intent2 = Intent(this,MainActivity::class.java)
            val nav = findViewById<View>(R.id.navigation)
            val popupMenu = PopupMenu(this, nav)
            popupMenu.menuInflater.inflate(R.menu.pages_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.timelineNav ->
                        Toast.makeText(this@timeline_screen, "Already on Timeline", Toast.LENGTH_SHORT).show()
                    R.id.accountNav ->
                        startActivity(intent)
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