package com.example.Chatbotik.fragments.mainScreen.achievement

import android.content.Context
import com.example.chatbotik.R


object AchievementsManager {
    private val achievements: MutableList<Achievement> = mutableListOf()
    private var num: Int = 0

    fun init(context: Context) {
        num++
        if (num == 1) {
            achievements.add(
                Achievement(
                    context.getString(R.string.first_connect),
                    context.getString(R.string.first_time_meet),
                    R.drawable.first_connect
                )
            )
            achievements.add(
                Achievement(
                    context.getString(R.string.linguist_beginner),
                    context.getString(R.string.first_lesson),
                    R.drawable.first_lesson
                )
            )
            achievements.add(
                Achievement(
                    context.getString(R.string.vocabulary_explorer),
                    context.getString(R.string.words50_achievment),
                    R.drawable.vocabulary
                )
            )
            achievements.add(
                Achievement(
                    context.getString(R.string.conversation_starter),
                    context.getString(R.string.first_5_messages),
                    R.drawable.conversation
                )
            )
        }
    }

    fun checkAchievement(achievementName: String) {
        val achievement = achievements.find { it.name == achievementName }
        achievement?.let {
            it.completed = true
        }
    }

    fun getAchievements(): List<Achievement> {
        return achievements
    }
}
