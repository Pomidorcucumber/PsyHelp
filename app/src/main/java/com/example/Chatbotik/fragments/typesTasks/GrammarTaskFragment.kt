package com.example.Chatbotik.fragments.typesTasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.Chatbotik.activity.TaskActivity
import com.example.chatbotik.R
import com.example.chatbotik.databinding.FragmentGrammarTaskBinding

class GrammarTaskFragment : Fragment() {
    private lateinit var binding: FragmentGrammarTaskBinding
    private val tasksList = listOf(Pair(Pair("I (to do) morning exercises.","do"), R.drawable.situation), Pair(Pair("She (to sleep) after dinner.","sleeps"), R.drawable.situation), Pair(Pair("They (to drink) tea every day.","drink"), R.drawable.situation))

    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGrammarTaskBinding.inflate(inflater, container, false)
        binding.textView8.visibility= View.INVISIBLE
        binding.textView9.visibility= View.INVISIBLE
        val view = binding.root
        val imageRes = tasksList[currentIndex].second
        binding.grammarImage.setImageResource(imageRes)
        binding.grammarDescription.text = tasksList[currentIndex].first.first
        return view
    }

    fun incrementIndex() {
        binding.grammarEditText.text.clear()
        currentIndex++
        binding.textView8.visibility= View.INVISIBLE
        binding.textView9.visibility= View.INVISIBLE
        if (currentIndex < tasksList.size) {
            val imageRes = tasksList[currentIndex].second
            binding.grammarDescription.text = tasksList[currentIndex].first.first
            binding.grammarImage.setImageResource(imageRes)
        } else {
            currentIndex = -1
            val taskActivity = activity as TaskActivity
            taskActivity.switchToNextFragment()
        }
    }

    fun checkAnswer() {
        val userAnswer = binding.grammarEditText.text.toString()
        if (isAnswerCorrect(userAnswer)) {
            binding.textView9.text = "Great job"
            binding.textView9.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            binding.textView9.setCompoundDrawablesWithIntrinsicBounds(R.drawable.good, 0, 0, 0)
            binding.textView9.visibility= View.VISIBLE
        } else {
            binding.textView8.text = "Incorrect"
            binding.textView8.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
            binding.textView8.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bad, 0, 0, 0)
            binding.textView8.visibility= View.VISIBLE
            binding.textView9.text = "Correct Answer:\n${tasksList[currentIndex].first.second}"
            binding.textView9.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
            binding.textView9.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            binding.textView9.visibility= View.VISIBLE
        }
    }

    private fun isAnswerCorrect(answer: String): Boolean {
        val correctAnswer = tasksList[currentIndex].first.second
        return answer.equals(correctAnswer, ignoreCase = true)
    }
}