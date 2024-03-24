package com.example.Chatbotik.achievement


object AchievementsManager {
    private val achievements: MutableList<Achievement> = mutableListOf()

    init {
        achievements.add(Achievement("Первый раз запустили приложение"))
        achievements.add(Achievement("Задание выполнено"))
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
