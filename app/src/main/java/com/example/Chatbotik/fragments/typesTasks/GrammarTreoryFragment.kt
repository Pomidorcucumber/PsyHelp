package com.example.Chatbotik.fragments.typesTasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.Chatbotik.activity.TaskActivity
import com.example.chatbotik.databinding.FragmentGrammarTreoryBinding

class GrammarTreoryFragment : Fragment() {
    private lateinit var binding: FragmentGrammarTreoryBinding
    private var currentIndex = 0
    private val tasksList = listOf(
        "Что такое Present Simple?\n" +
                "Это простое настоящее время, обозначающее действие в самом широком смысле этого слова. Одна из самых распространенных и простых форм в английском языке для описания действий.\n" +
                "Действия могут быть связаны с привычками, хобби, ежедневным событием вроде подъема по утрам или чем-то, что случается регулярно.\n" +
                "\n" +
                "Как образуется Present Simple?\n" +
                "Нет ничего проще, чем поставить глагол в форму Present Simple. Для этого нужно убрать у глагола в инфинитиве частицу «to» и поставить глагол после подлежащего. Это и есть основное правило Present Simple .\n" +
                "Утверждение:\n" +
                "I / We / You / They + V\n" +
                "She / He / It + V + s (es)\n" +
                "I go to work every day — Я хожу на работу каждый день.\n" +
                "They usually play tennis every weekend — Они обычно играют в теннис каждые выходные.\n" +
                "She brings me coffee every morning — Она приносит мне кофе каждое утро.\n" +
                "It snows in winter — Зимой идет снег.\n" +
                "ВАЖНО: В Present Simple форма глагола практически всегда совпадает с изначальной. Исключение составляет третье лицо единственного числа (he / she / it) — к нему прибавляется окончание -s:\n" +
                "I ride — She rides\n" +
                "I dream — He dreams\n" +
                "Если глагол оканчивается на -s, -ss, -sh, -ch, -x, -o, то к нему прибавляется окончание -es\n" +
                "I wish — She wishes\n" +
                "I teach — She teaches\n" +
                "Если глагол оканчивается на -y, а ему предшествует согласная, то к нему прибавляется окончание -es, но -y заменяется на -i\n" +
                "I try — She tries\n" +
                "I fly — He flies\n" +
                "Если глагол оканчивается на -y, а ему предшествует гласная, то к нему также прибавляется окончание -s, но -y не меняется.\n" +
                "I play — She plays\n" +
                "I stay — He stays\n"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGrammarTreoryBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.textView11.text = tasksList[currentIndex]
        return view
    }

    fun incrementIndex() {
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