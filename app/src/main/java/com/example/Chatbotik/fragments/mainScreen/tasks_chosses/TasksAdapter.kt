package com.example.Chatbotik.fragments.mainScreen.tasks_chosses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbotik.R

class TasksAdapter(private val tasks: List<Task>) :
    RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.text_task_name)
        val imageView: ImageView = itemView.findViewById(R.id.image_task_icon)
        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val movie = tasks[position]
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.titleTextView.text = task.name
        holder.imageView.setImageResource(task.icon)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}
