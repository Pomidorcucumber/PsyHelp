package com.example.Chatbotik.fragments.typesTasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.Chatbotik.activity.TaskActivity
import com.example.Chatbotik.fragments.typesTasksData.TextTaskData
import com.example.chatbotik.R
import com.example.chatbotik.databinding.FragmentTextTaskBinding

class TextTaskFragment : Fragment() {
    private lateinit var binding: FragmentTextTaskBinding
    lateinit var textTaskData: TextTaskData
    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        textTaskData = requireArguments().getParcelable("task_data")!!
        val tasksList = textTaskData.task
        binding = FragmentTextTaskBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.textContainer.text = textTaskData.text
        binding.textView10.text = tasksList[currentIndex].first
        setupQuestions()

        return view
    }

    private fun setupQuestions() {
        val tasksList = textTaskData.task
        val  questions  = tasksList[currentIndex].second.first
        for (question in questions) {
            val checkBox = CheckBox(requireContext())
            checkBox.text = question
            binding.questionsContainer.addView(checkBox)
        }
    }
    fun checkAnswers() {
        val tasksList = textTaskData.task
        val selectedAnswer = getSelectedAnswer()
        val correctAnswer = tasksList[currentIndex].second.second

        for (i in 0 until binding.questionsContainer.childCount) {
            val checkBox = binding.questionsContainer.getChildAt(i) as CheckBox

            if (checkBox.text == correctAnswer) {
                checkBox.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            } else {
                if (checkBox.text == selectedAnswer) {
                    checkBox.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                }
            }

            checkBox.isEnabled = false
        }
    }

    private fun getSelectedAnswer(): String {
        for (i in 0 until binding.questionsContainer.childCount) {
            val checkBox = binding.questionsContainer.getChildAt(i) as CheckBox
            if (checkBox.isChecked) {
                return checkBox.text.toString()
            }
        }
        return ""
    }
    fun incrementIndex() {
        val tasksList = textTaskData.task
        binding.questionsContainer.isEnabled = true
        currentIndex++
        if (currentIndex < tasksList.size) {
            binding.questionsContainer.removeAllViews()
            setupQuestions()
            binding.textView10.text = tasksList[currentIndex].first
        } else {
            currentIndex = -1
            val taskActivity = activity as TaskActivity
            taskActivity.switchToNextFragment()
        }
    }
}
