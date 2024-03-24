package com.example.Chatbotik.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.Chatbotik.fragments.typesTasksData.AudioTaskData
import com.example.Chatbotik.fragments.typesTasks.AudioTaskFragment
import com.example.Chatbotik.fragments.typesTasks.DictionaryFragment
import com.example.Chatbotik.fragments.typesTasks.GrammarTaskFragment
import com.example.Chatbotik.fragments.typesTasks.GrammarTreoryFragment
import com.example.Chatbotik.fragments.typesTasks.TextTaskFragment
import com.example.Chatbotik.fragments.typesTasks.WritingTextCheckFragment
import com.example.Chatbotik.fragments.typesTasksData.ComplexTaskData
import com.example.Chatbotik.fragments.typesTasksData.DictionaryTaskData
import com.example.Chatbotik.fragments.typesTasksData.GrammarTaskData
import com.example.Chatbotik.fragments.typesTasksData.GrammarTheoryData
import com.example.Chatbotik.fragments.typesTasksData.TextTaskData
import com.example.Chatbotik.fragments.typesTasksData.WritingTaskData
import com.example.chatbotik.R
import com.example.chatbotik.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {

    lateinit var binding: ActivityTaskBinding
    private var clicks = -1
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val complexTaskData = intent.getParcelableExtra<ComplexTaskData>("complex_task_data")
        binding.taskTitleTextView.text = when (complexTaskData!!.listTask[number]) {
            1 -> "Словарный запас"
            2 -> "Грамматика"
            3 -> "Текст"
            4 -> "Аудио"
            5 -> "Написание текста"
            6 -> "Теория по грамматике"
            else -> "Неизвестный тип задания"
        }

        when (complexTaskData.listTask[number]) {
            1 -> setupVocabularyTask(complexTaskData.dictionaryTask)
            2 -> setupGrammarTask(complexTaskData.grammarTask)
            3 -> setupTextTask(complexTaskData.textTask)
            4 -> setupAudioTask(complexTaskData.audioTask)
            5 -> setupWritingTask(complexTaskData.writingTask)
            6 -> setupGrammarTheory(complexTaskData.grammarTheoryTask)
        }

        binding.checkButton.setOnClickListener {
            onCheckButtonClick()
        }
    }

    private fun setupVocabularyTask(taskData: DictionaryTaskData) {
        val dictionaryFragment = DictionaryFragment()
        dictionaryFragment.arguments = Bundle().apply {
            putParcelable("task_data", taskData)
        }
        replaceFragment(dictionaryFragment)
        binding.checkButton.text = getString(R.string.след)
    }

    private fun setupGrammarTask(taskData: GrammarTaskData) {
        val grammarTaskFragment = GrammarTaskFragment()
        grammarTaskFragment.arguments = Bundle().apply {
            putParcelable("task_data", taskData)
        }
        replaceFragment(grammarTaskFragment)
        binding.checkButton.text = getString(R.string.check)
    }

    private fun setupTextTask(taskData: TextTaskData) {
        val textTaskFragment = TextTaskFragment()
        textTaskFragment.arguments = Bundle().apply {
            putParcelable("task_data", taskData)
        }
        replaceFragment(textTaskFragment)
        binding.checkButton.text = getString(R.string.check)
    }

    private fun setupAudioTask(taskData: AudioTaskData) {
        val audioTaskFragment = AudioTaskFragment()
        audioTaskFragment.arguments = Bundle().apply {
            putParcelable("task_data", taskData)
        }
        replaceFragment(audioTaskFragment)
        binding.checkButton.text = getString(R.string.check)
    }

    private fun setupWritingTask(taskData: WritingTaskData) {
        val writingTaskFragment = WritingTextCheckFragment()
        writingTaskFragment.arguments = Bundle().apply {
            putParcelable("task_data", taskData)
        }
        replaceFragment(writingTaskFragment)
        binding.checkButton.text = getString(R.string.check)
    }

    private fun setupGrammarTheory(taskData: GrammarTheoryData) {
        val grammarTheoryFragment = GrammarTreoryFragment()
       grammarTheoryFragment.arguments = Bundle().apply {
            putParcelable("task_data", taskData)
        }
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
        val complexTaskData = intent.getParcelableExtra<ComplexTaskData>("complex_task_data")
        binding.progressBar.progress += 100/ complexTaskData!!.listTask.size
        number++
        if (number < complexTaskData!!.listTask.size) {
            binding.taskTitleTextView.text = when (complexTaskData.listTask[number]) {
                1 -> "Словарный запас"
                2 -> "Грамматика"
                3 -> "Текст"
                4 -> "Аудио"
                5 -> "Написание текста"
                6 -> "Теория по грамматике"
                else -> "Неизвестный тип задания"
            }

            when (complexTaskData.listTask[number]) {
                1 -> setupVocabularyTask(complexTaskData.dictionaryTask)
                2 -> setupGrammarTask(complexTaskData.grammarTask)
                3 -> setupTextTask(complexTaskData.textTask)
                4 -> setupAudioTask(complexTaskData.audioTask)
                5 -> setupWritingTask(complexTaskData.writingTask)
                6 -> setupGrammarTheory(complexTaskData.grammarTheoryTask)
            }
        }else{
            val intent = Intent(this, ChooseTaskActivity::class.java)
            startActivity(intent)
        }
    }
}





