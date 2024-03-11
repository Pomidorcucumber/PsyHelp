package com.example.Chatbotik.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.chatbotik.R


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar!!.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val value = sharedPreferences.getString("reg", "Not idea")
            val valmeet = sharedPreferences.getString("meet", "Not idea")
            val intent = Intent(this, if (valmeet == "yes"){ if (value == "yes") Meeting::class.java else SignInAct::class.java} else if (value == "yes") Meeting::class.java else SignInAct::class.java)
            startActivity(intent)
            finish()
        }, 5000)

    }
}