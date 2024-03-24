package com.example.Chatbotik.fragments.mainScreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatbotik.databinding.FragmentSettingsBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Chatbotik.achievement.AchievementsAdapter
import com.example.Chatbotik.achievement.AchievementsManager

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private val achievements = AchievementsManager.getAchievements()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val adapter = AchievementsAdapter(achievements)
        binding.achievementsList.layoutManager = LinearLayoutManager(context)
        binding.achievementsList.adapter = adapter

        val sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val valmeet = sharedPreferences.getString("meet", "Not idea")

        if (valmeet == "yes") {
            AchievementsManager.checkAchievement("Первый раз запустили приложение")
            adapter.notifyDataSetChanged()
        }
        return binding.root
    }
}