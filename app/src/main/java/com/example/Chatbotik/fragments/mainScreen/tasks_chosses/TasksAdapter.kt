package com.example.Chatbotik.fragments.mainScreen.tasks_chosses

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
private val grammarTaskDataPresent1 = GrammarTaskData(
    3, listOf(
        Pair(Pair("I (to do) morning exercises.", "do"), R.drawable.situation),
        Pair(Pair("She (to sleep) after dinner.", "sleeps"), R.drawable.situation),
        Pair(Pair("They (to drink) tea every day.", "drink"), R.drawable.situation),
        Pair(Pair("He (to work) at a factory.", "works"), R.drawable.situation),
        Pair(Pair("We (to work) part-time.", "work"), R.drawable.situation)
    )
)
private val grammarTaskDataPresent2 = GrammarTaskData(
    3, listOf(
        Pair(Pair("Alice (to have) a sister.", "haves"), R.drawable.situation),
        Pair(Pair("Her sister’s name (to be) Ann.", "is"), R.drawable.situation),
        Pair(Pair("Ann (to be) a student.", "is"), R.drawable.situation),
        Pair(Pair("She (to get) up at seven o'clock.", "gets"), R.drawable.situation),
        Pair(Pair("She (to go) to the institute in the morning.", "goes"), R.drawable.situation)
    )
)
private val grammarTaskDataPresent3 = GrammarTaskData(
    3, listOf(
        Pair(
            Pair("My working day (to begin) at six o'clock.", "begins"), R.drawable.situation
        ),
        Pair(
            Pair(
                "I (to get) up, (to switch) on the TV and (to brush) my teeth.",
                "gets, switches"
            ), R.drawable.situation
        ),
        Pair(Pair("It (to take) me about twenty minutes..", "takes"), R.drawable.situation),
        Pair(Pair("I (to have) breakfast at seven o’clock.", "have"), R.drawable.situation),
        Pair(Pair("I (to leave) home at half past seven.", "leaves"), R.drawable.situation)
    )
)
private val grammarTaskDataPast1 = GrammarTaskData(
    3, listOf(
        Pair(Pair("I (to do) morning exercises.", "did"), R.drawable.situation),
        Pair(Pair("She (to sleep) after dinner.", "slept"), R.drawable.situation),
        Pair(Pair("They (to drink) tea every day.", "drank"), R.drawable.situation),
        Pair(Pair("He (to work) at a factory.", "worked"), R.drawable.situation),
        Pair(Pair("We (to work) part-time.", "worked"), R.drawable.situation)
    )
)
private val grammarTaskDataPast2 = GrammarTaskData(
    3, listOf(
        Pair(Pair("Alice (to have) a sister.", "had"), R.drawable.situation),
        Pair(Pair("Her sister’s name (to be) Ann.", "was"), R.drawable.situation),
        Pair(Pair("Ann (to be) a student.", "was"), R.drawable.situation),
        Pair(Pair("She (to get) up at seven o'clock.", "got"), R.drawable.situation),
        Pair(Pair("She (to go) to the institute in the morning.", "went"), R.drawable.situation)
    )
)
private val grammarTaskDataFuture1 = GrammarTaskData(
    3, listOf(
        Pair(Pair("I (to do) morning exercises.", "wiil do"), R.drawable.situation),
        Pair(Pair("She (to sleep) after dinner.", "will sleep"), R.drawable.situation),
        Pair(Pair("They (to drink) tea every day.", "will drink"), R.drawable.situation),
        Pair(Pair("He (to work) at a factory.", "will work"), R.drawable.situation),
        Pair(Pair("We (to work) part-time.", "will work"), R.drawable.situation)
    )
)
private val grammarTaskDataFuture2 = GrammarTaskData(
    3, listOf(
        Pair(Pair("Alice (to have) a sister.", "will have"), R.drawable.situation),
        Pair(Pair("Her sister’s name (to be) Ann.", "will be"), R.drawable.situation),
        Pair(Pair("Ann (to be) a student.", "will be"), R.drawable.situation),
        Pair(Pair("She (to get) up at seven o'clock.", "will get"), R.drawable.situation),
        Pair(
            Pair("She (to go) to the institute in the morning.", "will go"),
            R.drawable.situation
        )
    )
)
private val grammarTaskDataFuture3 = GrammarTaskData(
    3, listOf(
        Pair(
            Pair("My working day (to begin) at six o'clock.", "will begin"),
            R.drawable.situation
        ),
        Pair(
            Pair(
                "I (to get) up, (to switch) on the TV and (to brush) my teeth.",
                "will get, will switch"
            ), R.drawable.situation
        ),
        Pair(Pair("It (to take) me about twenty minutes..", "will take"), R.drawable.situation),
        Pair(
            Pair("I (to have) breakfast at seven o’clock.", "will have"), R.drawable.situation
        ),
        Pair(Pair("I (to leave) home at half past seven.", "will leave"), R.drawable.situation)
    )
)
private val grammarTaskDataPast3 = GrammarTaskData(
    3, listOf(
        Pair(
            Pair("My working day (to begin) at six o'clock.", "began"), R.drawable.situation
        ),
        Pair(
            Pair(
                "I (to get) up, (to switch) on the TV and (to brush) my teeth.", "got, switched"
            ), R.drawable.situation
        ),
        Pair(Pair("It (to take) me about twenty minutes..", "took"), R.drawable.situation),
        Pair(Pair("I (to have) breakfast at seven o’clock.", "had"), R.drawable.situation),
        Pair(Pair("I (to leave) home at half past seven.", "left"), R.drawable.situation)
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
private val wordsList2 = DictionaryTaskData(
    1, listOf(
        Pair("Section", "Раздел"),
        Pair("Dress", "Платье/одеваться"),
        Pair("Cloud", "Облако"),
        Pair("Surprise", "Сюрприз"),
        Pair("Quiet", "Тихо/тихий"),
        Pair("Iron", "Железо"),
        Pair("Single", "Один")
    )
)
private val wordsList3 = DictionaryTaskData(
    1, listOf(
        Pair("Stone", "Камень"),
        Pair("Tiny", "Крошечный"),
        Pair("Climb", "Подъем/взбираться"),
        Pair("Cool", "Крутой/прохладно"),
        Pair("Design", "Дизайн"),
        Pair("Flat", "Квартира(брит.)/плоский"),
        Pair("Jump", "Прыгать")
    )
)
private val theoryTaskPresent = GrammarTheoryData(
    4, listOf(
        "Что такое Present Simple?\n" + "Это простое настоящее время, обозначающее действие в самом широком смысле этого слова. Одна из самых распространенных и простых форм в английском языке для описания действий.\n" + "Действия могут быть связаны с привычками, хобби, ежедневным событием вроде подъема по утрам или чем-то, что случается регулярно.\n" + "\n" + "Как образуется Present Simple?\n" + "Нет ничего проще, чем поставить глагол в форму Present Simple. Для этого нужно убрать у глагола в инфинитиве частицу «to» и поставить глагол после подлежащего. Это и есть основное правило Present Simple .\n" + "Утверждение:\n" + "I / We / You / They + V\n" + "She / He / It + V + s (es)\n" + "I go to work every day — Я хожу на работу каждый день.\n" + "They usually play tennis every weekend — Они обычно играют в теннис каждые выходные.\n" + "She brings me coffee every morning — Она приносит мне кофе каждое утро.\n" + "It snows in winter — Зимой идет снег.\n" + "ВАЖНО: В Present Simple форма глагола практически всегда совпадает с изначальной. Исключение составляет третье лицо единственного числа (he / she / it) — к нему прибавляется окончание -s:\n" + "I ride — She rides\n" + "I dream — He dreams\n" + "Если глагол оканчивается на -s, -ss, -sh, -ch, -x, -o, то к нему прибавляется окончание -es\n" + "I wish — She wishes\n" + "I teach — She teaches\n" + "Если глагол оканчивается на -y, а ему предшествует согласная, то к нему прибавляется окончание -es, но -y заменяется на -i\n" + "I try — She tries\n" + "I fly — He flies\n" + "Если глагол оканчивается на -y, а ему предшествует гласная, то к нему также прибавляется окончание -s, но -y не меняется.\n" + "I play — She plays\n" + "I stay — He stays\n"
    )
)
private val theoryTaskPast = GrammarTheoryData(
    4, listOf(
        "Past Simple - простое прошедшее время\n" + "Время Past Simple используется для обозначения действия, которое произошло в определенное время в прошлом и время совершения которого уже истекло.\n" + "Для уточнения момента совершения действия в прошлом при использовании времени Past Simple обычно используются такие слова, как: \n" + "five days ago – пять дней назад; last year – в прошлом году; yesterday – вчера; \n" + "Образование Past Simple\n" + "Утвердительные предложения:\n" + "I played  We played.   You played.  You played.  He / she / it played.  They played.\n" + "Вопросительные предложения:\n" + "Did I play?\tDid we play?  Did you play?  Did you play?  Did he / she / it play?\t Did they play?\n" + "Отрицательные предложения:\n" + "I did not play.  We did not play.  You did not play.  You did not play.  He / she / it did not play.  They did not play.\n"
    )
)
private val theoryTaskFuture = GrammarTheoryData(
    4, listOf(
        "Future Simple - простое будущее время\n" + "    Время Future Simple ссылается на действие, которое совершится в неопределенном или отдаленном будущем.\n" + "    Простое будущее время в английском языке обычно используется с обстоятельствами:\n" + "    next year – в следующем году; in five years – через пять лет; in 2095 – в 2095 году\n" + "\n" + "    Образование Future Simple\n" + "\n" + "    Утвердительные предложения:\n" + "    I will play.  We will play.  You will play.  You will play.  He / she / it will play.  They will play.\n" + "    Вопросительные предложения:\n" + "    Will I play?\tWill we play?  Will you play?  Will you play?  Will he / she / it play?  Will they play?\n" + "    Отрицательные предложения:\n" + "    I will not play.  We will not play.  You will not play.\tYou will not play.  He / she / it will not play.  They will not play.\n"
    )
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
private val writingTask1 = WritingTaskData(6, listOf("Семья"))

class TasksAdapter(private val tasks: List<Task>) :
    RecyclerView.Adapter<TasksAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.text_task_name)
        val imageView: ImageView = itemView.findViewById(R.id.image_task_icon)

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val task = tasks[position]
                    val context = itemView.context
                    val intent = Intent(context, TaskActivity::class.java)
                    val comlexTask = ComplexTaskData(
                        listOf(1, 2, 3, 4, 5, 6),
                        audioTaskData1,
                        wordsList1,
                        grammarTaskDataPresent1,
                        theoryTaskPresent,
                        textTask1,
                        writingTask1
                    )
                    intent.putExtra("complex_task_data", comlexTask)
                    context.startActivity(intent)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.titleTextView.text = task.name
        holder.imageView.setImageResource(task.icon)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}
