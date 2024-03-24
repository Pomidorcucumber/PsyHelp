package com.example.Chatbotik.fragments.mainScreen

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.chatbotik.databinding.FragmentSettingsBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Chatbotik.fragments.mainScreen.achievement.Achievement
import com.example.Chatbotik.fragments.mainScreen.achievement.AchievementsAdapter
import com.example.Chatbotik.fragments.mainScreen.achievement.AchievementsManager
import com.example.chatbotik.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    lateinit var auth: FirebaseAuth
    private val achievements = mutableListOf<Achievement>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AchievementsManager.init(requireContext())
        achievements.addAll(AchievementsManager.getAchievements())
        auth = Firebase.auth
        val sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val valmeet = sharedPreferences.getString("meet", "Not idea")
        val value = sharedPreferences.getString("reg", "Not idea")
        val num_word = sharedPreferences.getInt("word_num", 0)
        val num_message = sharedPreferences.getInt("num_message", 0)
        if (valmeet == "yes") {
            AchievementsManager.checkAchievement(getString(R.string.first_connect))
        }
        if (value == "yes") {
            AchievementsManager.checkAchievement(getString(R.string.linguist_beginner))
        }
        if (num_word > 49) {
            AchievementsManager.checkAchievement(getString(R.string.vocabulary_explorer))
        }
        if (num_message > 4) {
            AchievementsManager.checkAchievement(getString(R.string.conversation_starter))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val namePer = sharedPreferences.getString("name", "Ivan")
        val surnamePer = sharedPreferences.getString("surname", "Ivanovich")
        binding.textView21.text = if(auth.currentUser?.displayName == null)"$namePer $surnamePer" else auth.currentUser?.displayName
        val photoUrl = auth.currentUser?.photoUrl
        val uri: Uri? = photoUrl?.let { Uri.parse(it.toString()) }
        binding.imageView12.setImageResource(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark)
        val adapter = AchievementsAdapter(achievements)
        binding.achievementsList.layoutManager = LinearLayoutManager(context)
        binding.achievementsList.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        ContextCompat.getDrawable(requireContext(), R.drawable.divider)?.let {
            dividerItemDecoration.setDrawable(it)
        }
        binding.achievementsList.addItemDecoration(dividerItemDecoration)

        achievements.clear()
        achievements.addAll(AchievementsManager.getAchievements())
        adapter.notifyDataSetChanged()

        return binding.root
    }
}