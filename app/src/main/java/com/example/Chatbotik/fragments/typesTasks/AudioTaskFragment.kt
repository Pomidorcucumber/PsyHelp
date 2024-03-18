package com.example.Chatbotik.fragments.typesTasks

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.Chatbotik.activity.TaskActivity
import com.example.Chatbotik.fragments.typesTasksData.AudioTaskData
import com.example.chatbotik.R
import com.example.chatbotik.databinding.FragmentAudioTaskBinding


class AudioTaskFragment : Fragment() {
    private lateinit var binding: FragmentAudioTaskBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var audioTaskData: AudioTaskData
    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAudioTaskBinding.inflate(inflater, container, false)
        val view = binding.root
        audioTaskData = requireArguments().getParcelable("task_data")!!
        val tasksList = audioTaskData.task
        binding.textView10.text = tasksList[currentIndex].second.first
        setupQuestions()

        mediaPlayer = MediaPlayer.create(requireContext(), tasksList[currentIndex].first)

        binding.audioButton.setOnClickListener {
            playAudio()
            binding.audioButton.setBackgroundResource(R.drawable.sound_on)
        }
        mediaPlayer.setOnCompletionListener {
            binding.audioButton.setBackgroundResource(R.drawable.sound_off)
        }
        return view
    }

    private fun playAudio() {
        mediaPlayer.start()
    }

    private fun setupQuestions() {
        val tasksList = audioTaskData.task
        val  questions  = tasksList[currentIndex].second.second.first
        for (question in questions) {
            val checkBox = CheckBox(requireContext())
            checkBox.text = question
            binding.questionsContainer.addView(checkBox)
        }
    }
    fun checkAnswers() {
        val tasksList = audioTaskData.task
        val selectedAnswer = getSelectedAnswer()
        val correctAnswer = tasksList[currentIndex].second.second.second

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
        val tasksList = audioTaskData.task
        binding.questionsContainer.isEnabled = true
        currentIndex++
        if (currentIndex < tasksList.size) {
            binding.questionsContainer.removeAllViews()
            setupQuestions()
            binding.textView10.text = tasksList[currentIndex].second.first
            mediaPlayer = MediaPlayer.create(requireContext(), tasksList[currentIndex].first)
            mediaPlayer.setOnCompletionListener {
                binding.audioButton.setBackgroundResource(R.drawable.sound_off)
            }
        } else {
            currentIndex = -1
            val taskActivity = activity as TaskActivity
            taskActivity.switchToNextFragment()
        }
    }
}
