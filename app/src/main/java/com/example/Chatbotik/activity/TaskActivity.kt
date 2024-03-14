package com.example.Chatbotik.activity

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.Chatbotik.fragments.typesTasks.AudioTaskFragment
import com.example.Chatbotik.fragments.typesTasks.DictionaryFragment
import com.example.Chatbotik.fragments.typesTasks.GrammarTaskFragment
import com.example.Chatbotik.fragments.typesTasks.GrammarTreoryFragment
import com.example.Chatbotik.fragments.typesTasks.TextTaskFragment
import com.example.Chatbotik.fragments.typesTasks.WritingTextCheckFragment
import com.example.chatbotik.R
import com.example.chatbotik.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {

    lateinit var binding: ActivityTaskBinding
    private var clicks = -1
    private var number = 0
    private var taskTypes = listOf(1, 2, 3, 4, 5, 6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.taskTitleTextView.text = when (taskTypes[number]) {
            1 -> "Словарный запас"
            2 -> "Грамматика"
            3 -> "Текст"
            4 -> "Аудио"
            5 -> "Написание текста"
            6 -> "Теория по грамматике"
            else -> "Неизвестный тип задания"
        }

        when (taskTypes[number]) {
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
        if (fragment is GrammarTreoryFragment) {
            fragment.incrementIndex()
        }
        if (fragment is WritingTextCheckFragment) {
            clicks = (clicks + 1) % 2
            if (clicks == 0) {
                fragment.checkAnswerAndDisplay()
            } else {
                fragment.incrementIndex()
            }
        }


    }

    fun switchToNextFragment() {
        number++
        if (number < taskTypes.size) {
            binding.taskTitleTextView.text = when (taskTypes[number]) {
                1 -> "Словарный запас"
                2 -> "Грамматика"
                3 -> "Текст"
                4 -> "Аудио"
                5 -> "Написание текста"
                6 -> "Теория по грамматике"
                else -> "Неизвестный тип задания"
            }

            when (taskTypes[number]) {
                1 -> setupVocabularyTask()
                2 -> setupGrammarTask()
                3 -> setupTextTask()
                4 -> setupAudioTask()
                5 -> setupWritingTask()
                6 -> setupGrammarTheory()
            }
        }else{
            val intent = Intent(this, ChooseTaskActivity::class.java)
            startActivity(intent)
        }
    }
}





