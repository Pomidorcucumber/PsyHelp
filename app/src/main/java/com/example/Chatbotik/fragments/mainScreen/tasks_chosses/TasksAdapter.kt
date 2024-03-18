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
                    val audioTaskData = AudioTaskData(4, listOf(Pair(R.raw.dog__us_1, Pair("My mother is a...", Pair(listOf("Doctor", "Nurse", "Writer", "Waitress"), "Doctor"))), Pair(R.raw.incredible ,Pair("My house is near the...", Pair(listOf("City", "Monastery", "Mountains", "Italy"), "Italy")))))
                    val grammarTaskData = GrammarTaskData(3, listOf(Pair(Pair("I (to do) morning exercises.","do"), R.drawable.situation), Pair(Pair("She (to sleep) after dinner.","sleeps"), R.drawable.situation), Pair(Pair("They (to drink) tea every day.","drink"), R.drawable.situation)))
                    val wordsList = DictionaryTaskData(1, listOf(Pair("Dog","Собака"), Pair("Cat", "Кошка"), Pair("House", "Дом"), Pair("Girl", "Девочка")))
                    val theoryTask = GrammarTheoryData(4, listOf(
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
                    ))
                    val textTask = TextTaskData(1, "My Wonderful Family\n" +
                            "I live in a house near the mountains. I have two brothers and one sister, and I was born last. My father teaches mathematics, and my mother is a nurse at a big hospital. My brothers are very smart and work hard in school. My sister is a nervous girl, but she is very kind. My grandmother also lives with us. She came from Italy when I was two years old. She has grown old, but she is still very strong. She cooks the best food!\n" +
                            "My family is very important to me. We do lots of things together. My brothers and I like to go on long walks in the mountains. My sister likes to cook with my grandmother. On the weekends we all play board games together. We laugh and always have a good time. I love my family very much.\n", listOf(Pair("My mother is a...", Pair(listOf("Doctor", "Nurse", "Writer", "Waitress"), "Doctor")), Pair("My house is near the...", Pair(listOf("City", "Monastery", "Mountains", "Italy"), "Italy")), Pair("", Pair(listOf(""), ""))))
                    val writingTask = WritingTaskData(6, listOf("Семья"))
                    val comlexTask = ComplexTaskData(listOf(1, 2, 3, 4, 5, 6), audioTaskData, wordsList,grammarTaskData , theoryTask, textTask, writingTask)
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

private fun Intent.putExtra(s: String, comlexTask: ComplexTaskData) {

}
