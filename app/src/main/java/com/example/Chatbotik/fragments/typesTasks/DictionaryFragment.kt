package com.example.Chatbotik.fragments.typesTasks

import android.animation.Animator
import android.animation.AnimatorInflater
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.Chatbotik.activity.TaskActivity
import com.example.chatbotik.R
import com.example.chatbotik.databinding.FragmentDictionaryBinding

class DictionaryFragment : Fragment() {
    lateinit var binding: FragmentDictionaryBinding
    private val wordsList = listOf(Pair("Dog","Собака"), Pair("Cat", "Кошка"), Pair("House", "Дом"))

    private var currentIndex = 0
    private var firstorsecond = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionaryBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.wordTextView.text = wordsList[currentIndex].first

        binding.cardLayout.setOnClickListener {
            flipCard()
        }

        return view
    }

    fun incrementIndex() {
        firstorsecond = 0
        currentIndex++
        if (currentIndex < wordsList.size) {
            binding.wordTextView.text =
                if (firstorsecond == 0) wordsList[currentIndex].first else wordsList[currentIndex].second
        } else {
            currentIndex = -1
            // Достигнут конец списка слов, переключаемся на фрагмент GrammarTaskFragment
            val taskActivity = activity as TaskActivity
            taskActivity.switchToNextFragment()
        }
    }

    private fun flipCard() {
        val rotation = AnimatorInflater.loadAnimator(requireContext(), R.animator.flip)
        rotation.setTarget(binding.cardLayout)
        binding.wordTextView.text = ""
        rotation.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                firstorsecond = (firstorsecond + 1) % 2
                binding.wordTextView.text =
                    if (firstorsecond == 0) wordsList[currentIndex].first else wordsList[currentIndex].second
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}
        })
        rotation.start()
    }
}
