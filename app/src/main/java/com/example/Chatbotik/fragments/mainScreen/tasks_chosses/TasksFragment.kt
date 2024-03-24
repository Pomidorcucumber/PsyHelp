package com.example.Chatbotik.fragments.mainScreen.tasks_chosses


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Chatbotik.activity.TaskActivity
import com.example.Chatbotik.fragments.typesTasksData.AudioTaskData
import com.example.Chatbotik.fragments.typesTasksData.ComplexTaskData
import com.example.Chatbotik.fragments.typesTasksData.DictionaryTaskData
import com.example.Chatbotik.fragments.typesTasksData.GrammarTaskData
import com.example.Chatbotik.fragments.typesTasksData.GrammarTheoryData
import com.example.Chatbotik.fragments.typesTasksData.TextTaskData
import com.example.Chatbotik.fragments.typesTasksData.WritingTaskData
import com.example.chatbotik.R
import com.example.chatbotik.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {
    private lateinit var binding: FragmentTasksBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TasksAdapter

    private val audioTaskData1 = AudioTaskData(
        4, listOf(
            Pair(
                R.raw.dog__us_1, Pair(
                    "My mother is a...",
                    Pair(listOf("Doctor", "Nurse", "Writer", "Waitress"), "Doctor")
                )
            ), Pair(
                R.raw.incredible, Pair(
                    "My house is near the...",
                    Pair(listOf("City", "Monastery", "Mountains", "Italy"), "Italy")
                )
            )
        )
    )

    private val audioTaskData2ru = AudioTaskData(
        4, listOf(
            Pair(
                R.raw.earth,
                Pair(
                    "Название деревни:",
                    Pair(listOf("Оймякон", "Целовка", "Долинка", "Минон"), "Оймякон")
                )
            ),
            Pair(
                R.raw.earth, Pair(
                    "Какие люди там живут?",
                    Pair(listOf("Веселые", "Грустные", "Странные", "Молчаливые"), "Веселые")
                )
            ), Pair(
                R.raw.maslenica, Pair(
                    "В какой день недели катаются на санках?",
                    Pair(listOf("Вторник", "Понедельник", "Четверг", "Суббота"), "Четверг")
                )
            ), Pair(
                R.raw.banya, Pair(
                    "Самое главное в бане?",
                    Pair(listOf("Температура", "Друзья", "Еда", "Веник"), "Веник")
                )
            ),
            Pair(
                R.raw.banya, Pair(
                    "Какая вода в бассейне в бане?",
                    Pair(
                        listOf(
                            "Теплая",
                            "Холодная",
                            "В бане нет бассейна",
                            "Нет правильного ответа"
                        ), "Холодная"
                    )
                )

            )
        )
    )

    private val grammarTaskDataPresent1 = GrammarTaskData(
        3, listOf(
            Pair(Pair("I (to do) morning exercises.", "do"), R.drawable.situation),
            Pair(Pair("She (to sleep) after dinner.", "sleeps"), R.drawable.situation),
            Pair(Pair("They (to drink) tea every day.", "drink"), R.drawable.situation),
            Pair(Pair("He (to work) at a factory.", "works"), R.drawable.situation),
            Pair(Pair("We (to work) part-time.", "work"), R.drawable.situation)
        )
    )
    private val grammarTaskDataPresent1ru = GrammarTaskData(
        3, listOf(
            Pair(Pair("Я (любить) смотреть телевизор.", "люблю"), R.drawable.situation),
            Pair(Pair("Она (заниматься) спортом.", "занимается"), R.drawable.situation),
            Pair(Pair("Они (пить) чай каждое утро.", "пьют"), R.drawable.situation),
            Pair(Pair("Он (работать) на заводе.", "работает"), R.drawable.situation),
            Pair(Pair("Мы (учиться) в школе.", "учимся"), R.drawable.situation)
        )
    )
    private val wordsList1 = DictionaryTaskData(
        1, listOf(
            Pair("Dog", "Собака"),
            Pair("Cat", "Кошка"),
            Pair("House", "Дом"),
            Pair("Girl", "Девочка"),
            Pair("Аge", "Возраст"),
            Pair("Explain", "объяснять"),
            Pair("Key", "ключ")
        )
    )

    private val theoryTaskPresent = GrammarTheoryData(
        4, listOf(
            "Что такое Present Simple?\n" + "Это простое настоящее время, обозначающее действие в самом широком смысле этого слова. Одна из самых распространенных и простых форм в английском языке для описания действий.\n" + "Действия могут быть связаны с привычками, хобби, ежедневным событием вроде подъема по утрам или чем-то, что случается регулярно.\n" + "\n" + "Как образуется Present Simple?\n" + "Нет ничего проще, чем поставить глагол в форму Present Simple. Для этого нужно убрать у глагола в инфинитиве частицу «to» и поставить глагол после подлежащего. Это и есть основное правило Present Simple .\n" + "Утверждение:\n" + "I / We / You / They + V\n" + "She / He / It + V + s (es)\n" + "I go to work every day — Я хожу на работу каждый день.\n" + "They usually play tennis every weekend — Они обычно играют в теннис каждые выходные.\n" + "She brings me coffee every morning — Она приносит мне кофе каждое утро.\n" + "It snows in winter — Зимой идет снег.\n" + "ВАЖНО: В Present Simple форма глагола практически всегда совпадает с изначальной. Исключение составляет третье лицо единственного числа (he / she / it) — к нему прибавляется окончание -s:\n" + "I ride — She rides\n" + "I dream — He dreams\n" + "Если глагол оканчивается на -s, -ss, -sh, -ch, -x, -o, то к нему прибавляется окончание -es\n" + "I wish — She wishes\n" + "I teach — She teaches\n" + "Если глагол оканчивается на -y, а ему предшествует согласная, то к нему прибавляется окончание -es, но -y заменяется на -i\n" + "I try — She tries\n" + "I fly — He flies\n" + "Если глагол оканчивается на -y, а ему предшествует гласная, то к нему также прибавляется окончание -s, но -y не меняется.\n" + "I play — She plays\n" + "I stay — He stays\n"
        )
    )
    private val theoryTaskPresentru = GrammarTheoryData(
        4, listOf(
            "The present tense in Russian refers to actions or states that are happening in the present moment.\n"  + "It is used to talk about routines, habits, general truths, and actions happening at the present time.\n" + "To form the present tense, we typically use verb conjugation, which means that the verb changes its ending depending on the subject of the sentence.\n" +"For example:\n" + "\n" + "Он сейчас спит. – He is sleeping now.\n" + "\n" + "Я все ещё готовлю обед. – I am still cooking lunch.")
    )
    private val textTask1 = TextTaskData(
        1,
        "First, I wake up. Then, I get dressed. I walk to school. I do not ride a bike. I do not ride the bus. I like to go to school. It rains. I do not like rain. I eat lunch. I eat a sandwich and an apple.\n" + "I play outside. I like to play. I read a book. I like to read books. I walk home. I do not like walking home. My mother cooks soup for dinner. The soup is hot. Then, I go to bed. I do not like to go to bed.\n",
        listOf(
            Pair(
                "What happens first?",
                Pair(listOf("Wake up", "Eat lunch", "Get dressed", "Walk to school"), "Wake up")
            ), Pair(
                "What do I like?",
                Pair(listOf("Books", "Rain", "Going to bed", "Walking home"), "Books")
            ), Pair(
                "How do I go to school?", Pair(
                    listOf("I walk.", "I drive a car.", "I ride a bike.", "I ride the bus."),
                    "I walk."
                )
            ), Pair(
                "What do I eat for dinner?",
                Pair(listOf("Sandwich", "Pie", "Soup", "Apple"), "Soup.")
            ), Pair(
                "What do I not like?",
                Pair(listOf("Soup", "Going to bed", "Playing", "Going to school"), "Going to bed")
            )
        )
    )
    private val textTask1ru = TextTaskData(
        1,
        "К Виталику пришел его друг Сережа. В банке он увидел рыбку. Сережа достал свисток. Виталик за свисток отдал ему рыбку.\n" +
                "       Дома Сережа радовался. Виталик грустил. Он смотрел на пустую банку. В руках у него был свисток.\n" +
                "       Но свисток его не радовал.",
        listOf(
            Pair(
                "Как звали друга Виталика?",
                Pair(listOf("Александр", "Артем", "Сережа", "Антон"), "Сережа")
            ), Pair(
                "Кто был в банке?",
                Pair(listOf("Рыбка", "Таракан", "Муха", "Камень"), "Рыбка")
            ), Pair(
                "Что достал Сережа?", Pair(
                    listOf("Телефон", "Бутылку", "Свисток", "Камень"),
                    "Свисток"
                )
            ), Pair(
                "Что сделали ребята?",
                Pair(listOf("Скучали", "Обменялись вещами", "Пошли гулять", "Играли"), "Обменялись вещами")
            ), Pair(
                "Из-за чего грустил Виталик?",
                Pair(listOf("Из-за пустой банки", "Из-за оценок", "Из-за ссоры с родителями", "Из-за песни"), "Из-за пустой банки")
            )
        )
    )
    private val writingTask1 = WritingTaskData(6, listOf("Семья"))
    private val writingTask2ru = WritingTaskData(6, listOf("Family"))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewTasks
        val sharedPreferences =
            requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val language = sharedPreferences.getString("language", "Нет сохраненного текста")
        val spanCount = 2
        val layoutManager = GridLayoutManager(activity, spanCount)
        recyclerView.layoutManager = layoutManager
        val tasks = listOf(
            Task("Новые слова (Daily)", R.drawable.dictionary_icon),
            Task("Новые слова (Daily)", R.drawable.dictionary_icon),
            Task("Новые слова (Daily)", R.drawable.dictionary_icon),
            Task("Грамматика (Present Simple)", R.drawable.grammar_icon),
            Task("Грамматика (Present Simple)", R.drawable.grammar_icon),
            Task("Грамматика (Present Simple)", R.drawable.grammar_icon),
            Task("Грамматика (Past Simple)", R.drawable.grammar_icon),
            Task("Грамматика (Past Simple)", R.drawable.grammar_icon),
            Task("Грамматика (Past Simple)", R.drawable.grammar_icon),
            Task("Грамматика (Future Simple)", R.drawable.grammar_icon),
            Task("Грамматика (Future Simple)", R.drawable.grammar_icon),
            Task("Грамматика (Future Simple)", R.drawable.grammar_icon),
            Task("Аудирование(Daily)", R.drawable.audio_icon),
            Task("Аудирование(Daily)", R.drawable.audio_icon),
            Task("Аудирование(Daily)", R.drawable.audio_icon),
            Task("Чтение (Daily)", R.drawable.reading_icon),
            Task("Чтение (Daily)", R.drawable.reading_icon),
            Task("Чтение (Daily)", R.drawable.reading_icon),
            Task("Написание эссе", R.drawable.writting_icon)
        )

        adapter = TasksAdapter(tasks, requireContext())
        recyclerView.adapter = adapter
        binding.buttonWithImageAndText.setOnClickListener {
            val i = Intent(requireContext(), TaskActivity::class.java)
            val complexTask = ComplexTaskData(
                listOf(1, 2, 3, 4, 5, 6),
                if (language == "English") audioTaskData1 else audioTaskData2ru,
                wordsList1,
                if (language == "English") grammarTaskDataPresent1 else grammarTaskDataPresent1ru,
                if (language == "English") theoryTaskPresent else theoryTaskPresentru,
                if (language == "English") textTask1 else textTask1ru,
                if (language == "English") writingTask1 else writingTask2ru
            )
            i.putExtra("complex_task_data", complexTask)
            startActivity(i)
        }
        return binding.root
    }
}
