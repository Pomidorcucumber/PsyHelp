package com.example.Chatbotik.fragments.typesTasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.Chatbotik.activity.TaskActivity
import com.example.chatbotik.R
import com.example.chatbotik.databinding.FragmentTextTaskBinding

class TextTaskFragment : Fragment() {
    private lateinit var binding: FragmentTextTaskBinding
    private val text = "My Wonderful Family\n" +
            "I live in a house near the mountains. I have two brothers and one sister, and I was born last. My father teaches mathematics, and my mother is a nurse at a big hospital. My brothers are very smart and work hard in school. My sister is a nervous girl, but she is very kind. My grandmother also lives with us. She came from Italy when I was two years old. She has grown old, but she is still very strong. She cooks the best food!\n" +
            "My family is very important to me. We do lots of things together. My brothers and I like to go on long walks in the mountains. My sister likes to cook with my grandmother. On the weekends we all play board games together. We laugh and always have a good time. I love my family very much.\n"
    private val tasksList = listOf(Pair("My mother is a...", Pair(listOf("Doctor", "Nurse", "Writer", "Waitress"), "Doctor")), Pair("My house is near the...", Pair(listOf("City", "Monastery", "Mountains", "Italy"), "Italy")), Pair("", Pair(listOf(""), "")))
    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTextTaskBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.textContainer.text = text
        binding.textView10.text = tasksList[currentIndex].first
        setupQuestions()

        return view
    }

    private fun setupQuestions() {
        val  questions  = tasksList[currentIndex].second.first
        for (question in questions) {
            val checkBox = CheckBox(requireContext())
            checkBox.text = question
            binding.questionsContainer.addView(checkBox)
        }
    }
    fun checkAnswers() {
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
