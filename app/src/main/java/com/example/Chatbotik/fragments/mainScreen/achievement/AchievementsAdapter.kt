package com.example.Chatbotik.fragments.mainScreen.achievement


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.chatbotik.R
import androidx.recyclerview.widget.RecyclerView

class AchievementsAdapter(private val achievements: List<Achievement>) :
    RecyclerView.Adapter<AchievementsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val achievementTextView: TextView = itemView.findViewById(R.id.achievementNameTextView)
        val achievementDesc: TextView = itemView.findViewById(R.id.descAchiev)
        val achievementPhoto: ImageView = itemView.findViewById(R.id.imageAchiev)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_achievement, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val achievement = achievements[position]
        holder.achievementTextView.text = achievement.name
        holder.achievementDesc.text = achievement.description
        holder.achievementPhoto.setImageResource(achievement.photoInt)
        if (achievement.completed) {
            holder.achievementTextView.setTextColor(holder.itemView.resources.getColor(R.color.white))
        }
    }

    override fun getItemCount(): Int {
        return achievements.size
    }
}
