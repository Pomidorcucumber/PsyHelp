package com.example.Chatbotik.fragments.typesTasks
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.Chatbotik.activity.TaskActivity
import com.example.chatbotik.databinding.FragmentWritingTextCheckBinding

class WritingTextCheckFragment : Fragment() {
    private lateinit var binding: FragmentWritingTextCheckBinding
    private val topics = listOf("Семья")
    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWritingTextCheckBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.textView11.visibility = View.INVISIBLE
        binding.textView12.text = topics[currentIndex]
        return view
    }

    fun checkAnswerAndDisplay() {
        val answer = binding.editText.text.toString().trim()
        val result = checkTextWithLanguageTool(answer)
        binding.textView11.text = result
        binding.textView11.visibility = View.VISIBLE
    }
    private fun checkTextWithLanguageTool(text: String): String {
        return "Very good"
    }

    fun incrementIndex() {
        binding.textView11.visibility = View.INVISIBLE
        currentIndex++
        if (currentIndex < topics.size) {
            binding.textView12.text = topics[currentIndex]
        } else {
            currentIndex = -1
            val taskActivity = activity as TaskActivity
            taskActivity.switchToNextFragment()
        }
    }
}