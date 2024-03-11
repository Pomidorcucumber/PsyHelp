package com.example.Chatbotik.activity

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.Chatbotik.fragments.AudioTaskFragment
import com.example.Chatbotik.fragments.DictionaryFragment
import com.example.Chatbotik.fragments.GrammarTaskFragment
import com.example.Chatbotik.fragments.GrammarTreoryFragment
import com.example.Chatbotik.fragments.TextTaskFragment
import com.example.Chatbotik.fragments.WritingTextCheckFragment
import com.example.chatbotik.R
import com.example.chatbotik.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {

    lateinit var binding: ActivityTaskBinding
    private var clicks = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val taskTypes = intent.getIntExtra("taskType", 1)
        binding.taskTitleTextView.text = when (taskTypes) {
            1 -> "Словарный запас"
            2 -> "Грамматика"
            3 -> "Текст"
            4 -> "Аудио"
            5 -> "Написание текста"
            6 -> "Теория по грамматике"
            else -> "Неизвестный тип задания"
        }

        when (taskTypes) {
            1 -> setupVocabularyTask()
            2 -> setupGrammarTask()
            3 -> setupTextTask()
            4 -> setupAudioTask()
            5 -> setupWritingTask()
            6 -> setupGrammarTheory()
        }

        binding.checkButton.setOnClickListener {
            onCheckButtonClick()
        }
    }

    private fun setupVocabularyTask() {
        val dictionaryFragment = DictionaryFragment()
        replaceFragment(dictionaryFragment)
        binding.checkButton.text = getString(R.string.след)
    }

    private fun setupGrammarTask() {
        val grammarTaskFragment = GrammarTaskFragment()
        replaceFragment(grammarTaskFragment)
        binding.checkButton.text = getString(R.string.check)
    }

    private fun setupTextTask() {
        val textTaskFragment = TextTaskFragment()
        replaceFragment(textTaskFragment)
        binding.checkButton.text = getString(R.string.check)
    }

    private fun setupAudioTask() {
        val audioTaskFragment = AudioTaskFragment()
        replaceFragment(audioTaskFragment)
        binding.checkButton.text = getString(R.string.check)
    }

    private fun setupWritingTask() {
        val writingTaskFragment = WritingTextCheckFragment()
        replaceFragment(writingTaskFragment)
        binding.checkButton.text = getString(R.string.check)
    }

    private fun setupGrammarTheory() {
        val grammarTheoryFragment = GrammarTreoryFragment()
        replaceFragment(grammarTheoryFragment)
        binding.checkButton.text = getString(R.string.check)
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.taskContainer.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun onCheckButtonClick() {
        val fragment = supportFragmentManager.findFragmentById(binding.taskContainer.id)
        if (fragment is DictionaryFragment) {
            fragment.incrementIndex()
        }
        if (fragment is GrammarTaskFragment) {
            clicks = (clicks + 1) % 2
            if (clicks == 0) {
                fragment.checkAnswer()
            } else {
                fragment.incrementIndex()
            }
        }
        if (fragment is TextTaskFragment) {
            clicks = (clicks + 1) % 2
            if (clicks == 0) {
                fragment.checkAnswers()
            } else {
                fragment.incrementIndex()
            }
        }
        if (fragment is AudioTaskFragment) {
            clicks = (clicks + 1) % 2
            if (clicks == 0) {
                fragment.checkAnswers()
            } else {
                fragment.incrementIndex()
            }
        }

    }
}





