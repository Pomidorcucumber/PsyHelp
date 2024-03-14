package com.example.Chatbotik.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.Chatbotik.fragments.mainScreen.ChatFragment
import com.example.Chatbotik.fragments.mainScreen.PodcastsFragment
import com.example.Chatbotik.fragments.mainScreen.SettingsFragment
import com.example.Chatbotik.fragments.mainScreen.TasksFragment
import com.example.chatbotik.R
import com.example.chatbotik.databinding.ActivityChooseTaskBinding

class ChooseTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseTaskBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.action_tasks -> TasksFragment()
                R.id.action_podcasts -> PodcastsFragment()
                R.id.action_chat -> ChatFragment()
                R.id.action_settings -> SettingsFragment()
                else -> throw IllegalArgumentException("Invalid menu item ID")
            }

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()

            true
        }

        // Set default fragment
        binding.bottomNavigation.selectedItemId = R.id.action_tasks
    }
}
