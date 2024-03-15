package com.example.Chatbotik.fragments.mainScreen.tasks_chosses


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbotik.R
import com.example.chatbotik.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {
    private lateinit var binding: FragmentTasksBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewTasks
        val spanCount = 2
        val layoutManager = GridLayoutManager(activity, spanCount)
        recyclerView.layoutManager = layoutManager
        val tasks = listOf(
            Task("Задание 1", R.drawable.dictionary_icon),
            Task("Задание 2", R.drawable.dictionary_icon),
            Task("Задание 3", R.drawable.dictionary_icon),
            Task("Задание 4", R.drawable.dictionary_icon),
            Task("Задание 5", R.drawable.dictionary_icon),
            Task("Задание 6", R.drawable.dictionary_icon)
        )

        adapter = TasksAdapter(tasks)
        recyclerView.adapter = adapter
        return binding.root
    }
}
