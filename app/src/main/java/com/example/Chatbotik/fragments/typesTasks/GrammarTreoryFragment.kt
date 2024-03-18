package com.example.Chatbotik.fragments.typesTasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.Chatbotik.activity.TaskActivity
import com.example.Chatbotik.fragments.typesTasksData.GrammarTheoryData
import com.example.chatbotik.databinding.FragmentGrammarTreoryBinding

class GrammarTreoryFragment : Fragment() {
    private lateinit var binding: FragmentGrammarTreoryBinding
    private var currentIndex = 0
    lateinit var grammarTheoryData: GrammarTheoryData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        grammarTheoryData = requireArguments().getParcelable("task_data")!!
        val tasksList = grammarTheoryData.task
        binding = FragmentGrammarTreoryBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.textView11.text = tasksList[currentIndex]
        return view
    }

    fun incrementIndex() {
        val tasksList = grammarTheoryData.task
        currentIndex++
        if (currentIndex < tasksList.size) {
            binding.textView11.text = tasksList[currentIndex]
        } else {
            currentIndex = -1
            val taskActivity = activity as TaskActivity
            taskActivity.switchToNextFragment()
        }
    }
}