package com.example.Chatbotik.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.chatbotik.R
import com.example.chatbotik.databinding.ActivityMainScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainScreen : AppCompatActivity() {
    lateinit var binding: ActivityMainScreenBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goNewView(binding)
        auth = Firebase.auth
    }
    private fun goNewView(binding: ActivityMainScreenBinding) {

            binding.button2.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("name", binding.button2.text)
                startActivity(intent)
                finish()
        }
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", binding.button.text)
            startActivity(intent)
            finish()
        }
        binding.button3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", binding.button3.text)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_mus, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.exit){
            auth.signOut()
            finish()
            val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("reg", "no")
            editor.putString("name", "")
            editor.putString("surname", "")
            editor.apply()
            val i = Intent(this, SignInAct::class.java)
            startActivity(i)
        }else if (item.itemId == R.id.music_bt){
            val i = Intent(this, MainScreen::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }
}