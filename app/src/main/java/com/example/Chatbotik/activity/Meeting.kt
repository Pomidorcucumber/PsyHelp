package com.example.Chatbotik.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.Chatbotik.fragments.typesTasksData.AudioTaskData
import com.example.Chatbotik.fragments.typesTasksData.ComplexTaskData
import com.example.Chatbotik.fragments.typesTasksData.DictionaryTaskData
import com.example.Chatbotik.fragments.typesTasksData.GrammarTaskData
import com.example.Chatbotik.fragments.typesTasksData.GrammarTheoryData
import com.example.Chatbotik.fragments.typesTasksData.TextTaskData
import com.example.Chatbotik.fragments.typesTasksData.WritingTaskData
import com.example.chatbotik.R
import com.example.Chatbotik.notification.NotificationPermissionDialog
import com.example.chatbotik.databinding.ActivityMeetingBinding
import java.util.Timer
import kotlin.concurrent.timerTask


class Meeting : AppCompatActivity() {
    private lateinit var binding: ActivityMeetingBinding
    private var autoTypeText = "Hi there! I'm Swift!"
    private var delay: Long = 50
    private var timer = Timer()
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
    private val theoryTaskPresentkz = GrammarTheoryData(
        4, listOf(
            "2. Осы шақ\n" +
                    "\n" +
                    "Іс-әрекет, қимылдың сөйлеп тұрған кезде өтіп жатқанын білдіретін етістік шағының түрін осы шақ деп атайды.\n" +
                    "\n" +
                    "Осы шақ жасалуы мен мағынасына қарай нақ осы шақ және ауыспалы осы шақ деп бөлінеді.\n" +
                    "\n" +
                    "1) Нақ осы шақ деп қимылдың дәл сөйлеп тұрған кезге сәйкес келуін айтамыз.\n" +
                    "\n" +
                    "Мысалы: Мен отырмын (жүрмін, тұрмын, жатырмын). Біз отырмыз (жүрміз, тұрмыз, жатырмыз)\n" +
                    "\n" +
                    "Күрделі нақ осы шақта негізгі етістік -ып, -іп, -п жұрнақтарымен келіп, отыр, тұр, жүр, жатыр етістіктері көмекші етістік қызметінде жіктеліп жұмсалады.\n" +
                    "\n" +
                    "Мен оқып жатырмын. Біз оқып жатырмыз."
        )
    )
    private val grammarTaskDataPresent1kz = GrammarTaskData(
        3, listOf(
            Pair(Pair("Мен теледидарды көруді жақсы (көру).", "көремін"), R.drawable.situation),
            Pair(Pair("Ол спортпен (айналысу.", "айналысады"), R.drawable.situation),
            Pair(Pair("Олар әр таңертеңде шай (ішу).", "ішеді"), R.drawable.situation),
            Pair(Pair("Ол зауытта жұмыс (істеу).", "істеді "), R.drawable.situation),
            Pair(Pair("Біз мектепте (оқу) .", "оқимыз"), R.drawable.situation)
        )
    )
    private
    val wordsList1kz =
        DictionaryTaskData(
            1,
            listOf(
                Pair(
                    "Ит",
                    "Собака"
                ),
                Pair(
                    "Мысық",
                    "Кошка"
                ),
                Pair(
                    "Үй",
                    "Дом"
                ),
                Pair(
                    "Қыз",
                    "Девочка"
                ),
                Pair(
                    "Жас",
                    "Возраст"
                ),
                Pair(
                    "Түсіндіру",
                    "Объяснять"
                ),
                Pair(
                    "Кілт",
                    "Ключ"
                )
            )
        )
    private val writingTask1 = WritingTaskData(6, listOf("Семья"))
    private val writingTask2ru = WritingTaskData(6, listOf("Family"))

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMeetingBinding.inflate(layoutInflater)
        binding.progressBar2.visibility = View.INVISIBLE
        binding.radiotapok.visibility = View.GONE
        binding.checktapok.visibility = View.GONE
        setContentView(binding.root)
        supportActionBar!!.hide()
        startAutoTypeText()
        var howManyClick = 0

        binding.imageView5.setOnClickListener {
            val i = Intent(this, Registerr::class.java)
            startActivity(i)
        }
        binding.button9.setOnClickListener {
            howManyClick++
            when (howManyClick) {
                1 -> {
                    timer = Timer()
                    delay = 25
                    autoTypeText = "Just 7 quick questions \n before we start your first\n lesson!"
                    val animation = TranslateAnimation(0f, 0f, 175f, 0f)
                    animation.duration = 100
                    binding.textView7.translationY = -175f
                    binding.textView7.startAnimation(animation)
                    startAutoTypeText()
                    binding.imageView4.setImageResource(R.drawable.enotbighey)
                    binding.imageView5.setOnClickListener {
                        val i = Intent(this, SignInAct::class.java)
                        startActivity(i)
                    }
                }

                2 -> {
                    binding.imageView5.setOnClickListener {
                        howManyClick -= 2
                        binding.button9.performClick()
                    }
                    binding.textView7.visibility = View.INVISIBLE
                    binding.progressBar2.progress = 20
                    binding.progressBar2.visibility = View.VISIBLE
                    val animation = TranslateAnimation(0f, -350f, 0f, -850f)
                    animation.duration = 1500
                    binding.option3.setButtonDrawable(android.R.drawable.btn_radio)
                    binding.option2.setButtonDrawable(android.R.drawable.btn_radio)
                    binding.option1.setButtonDrawable(android.R.drawable.btn_radio)
                    binding.option.setButtonDrawable(android.R.drawable.btn_radio)
                    animation.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation?) {}

                        override fun onAnimationEnd(animation: Animation?) {
                            binding.imageView4.translationY = -850f
                            binding.imageView4.translationX = -350f
                            binding.textView7.translationY = -600f
                            binding.textView7.translationX = 150f
                            binding.textView7.visibility = View.VISIBLE
                            binding.option3.isClickable = true
                            timer = Timer()
                            delay = 25
                            autoTypeText = "What would you like to \n learn?"
                            startAutoTypeText()
                            val usaDrawable1: Drawable? =
                                ContextCompat.getDrawable(this@Meeting, R.drawable.usa)
                            val usaDrawable3: Drawable? =
                                ContextCompat.getDrawable(this@Meeting, R.drawable.kazakstan)
                            binding.option1.setCompoundDrawablesWithIntrinsicBounds(
                                usaDrawable3,
                                null,
                                null,
                                null
                            )
                            val usaDrawable2: Drawable? =
                                ContextCompat.getDrawable(this@Meeting, R.drawable.russia)
                            binding.option2.setCompoundDrawablesWithIntrinsicBounds(
                                usaDrawable2,
                                null,
                                null,
                                null
                            )
                            binding.option3.setCompoundDrawablesWithIntrinsicBounds(
                                usaDrawable1,
                                null,
                                null,
                                null
                            )
                            binding.radiotapok.visibility = View.VISIBLE
                            binding.option.visibility = View.GONE
                        }

                        override fun onAnimationRepeat(animation: Animation?) {}
                    })
                    binding.imageView4.startAnimation(animation)
                }

                3 -> {
                    binding.imageView5.setOnClickListener {
                        howManyClick -= 2
                        binding.button9.performClick()
                    }
                    if (binding.option1.isChecked || binding.option2.isChecked || binding.option3.isChecked) {
                        binding.radiotapok.visibility = View.INVISIBLE
                        if (binding.option1.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("language", binding.option1.text.toString())
                            editor.apply()
                            binding.option1.isChecked = false
                        }
                        if (binding.option3.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("language", binding.option3.text.toString())
                            editor.apply()
                            binding.option3.isChecked = false
                        }

                        if (binding.option2.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("language", binding.option2.text.toString())
                            editor.apply()
                            binding.option2.isChecked = false
                        }
                        val sharedPreferences =
                            getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                        val retrievedText =
                            sharedPreferences.getString("language", "Нет сохраненного текста").toString().lowercase()
                        timer = Timer()
                        delay = 25
                        autoTypeText = "How much $retrievedText do\n you know?"
                        startAutoTypeText()
                        binding.progressBar2.progress = 40

                        binding.option3.setButtonDrawable(android.R.drawable.btn_radio)
                        binding.option2.setButtonDrawable(android.R.drawable.btn_radio)
                        binding.option1.setButtonDrawable(android.R.drawable.btn_radio)
                        binding.option.setButtonDrawable(android.R.drawable.btn_radio)
                        val usaDrawable1: Drawable? =
                            ContextCompat.getDrawable(this@Meeting, R.drawable.firstlevel)
                        binding.option1.setCompoundDrawablesWithIntrinsicBounds(
                            usaDrawable1,
                            null,
                            null,
                            null
                        )
                        val usaDrawable2: Drawable? =
                            ContextCompat.getDrawable(this@Meeting, R.drawable.secondlevel)
                        binding.option2.setCompoundDrawablesWithIntrinsicBounds(
                            usaDrawable2,
                            null,
                            null,
                            null
                        )
                        val usaDrawable3: Drawable? =
                            ContextCompat.getDrawable(this@Meeting, R.drawable.thirdlevel)
                        binding.option3.setCompoundDrawablesWithIntrinsicBounds(
                            usaDrawable3,
                            null,
                            null,
                            null
                        )
                        val usaDrawable: Drawable? =
                            ContextCompat.getDrawable(this@Meeting, R.drawable.forthlevel)
                        binding.option.setCompoundDrawablesWithIntrinsicBounds(
                            usaDrawable,
                            null,
                            null,
                            null
                        )
                        binding.option.visibility = View.VISIBLE
                        binding.radiotapok.visibility = View.VISIBLE
                        binding.option.text = "I am intermediate or higher"
                        binding.option1.text = "I'm new to $retrievedText"
                        binding.option2.text = "I know some words and phrases"
                        binding.option3.text = "I can have simple conversations"
                    } else {
                        howManyClick--
                        Toast.makeText(this, "Please select a language", Toast.LENGTH_SHORT).show()
                    }
                }

                4 -> {
                    binding.imageView5.setOnClickListener {
                        howManyClick -= 2
                        binding.button9.performClick()
                    }
                    if (binding.option1.isChecked || binding.option2.isChecked || binding.option3.isChecked || binding.option.isChecked) {
                        binding.radiotapok.visibility = View.INVISIBLE
                        if (binding.option1.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("level", "level1")
                            editor.apply()
                        }

                        if (binding.option2.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("level", "level2")
                            editor.apply()
                        }
                        if (binding.option3.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("level", "level3")
                            editor.apply()
                        }

                        if (binding.option.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("level", "level4")
                            editor.apply()
                        }
                        val sharedPreferences =
                            getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                        val retrievedText =
                            sharedPreferences.getString("level", "Нет сохраненного текста")

                        timer = Timer()
                        delay = 25
                        autoTypeText = when (retrievedText) {
                            "level1" -> "Okay, let's start\n all over again!"
                            "level2" -> "That's good, let's\n go conquer new \nheights!"
                            "level3" -> "This is great,\n let's make it perfect!"
                            "level4" -> "Okay, great!"
                            else -> {
                                ""
                            }
                        }
                        startAutoTypeText()
                    } else {
                        howManyClick--
                        Toast.makeText(this, "Please select a level", Toast.LENGTH_SHORT).show()
                    }
                }

                5 -> {
                    binding.imageView5.setOnClickListener {
                        howManyClick -= 3
                        binding.button9.performClick()
                    }
                    binding.checktapok.visibility = View.VISIBLE
                    val sharedPreferences =
                        getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                    val retrievedText =
                        sharedPreferences.getString("language", "Нет сохраненного текста").toString().lowercase()
                    timer = Timer()
                    delay = 25
                    autoTypeText = "Why do you learning \n$retrievedText?"
                    startAutoTypeText()
                    binding.progressBar2.progress = 60
                    binding.check5.setOnCheckedChangeListener { _, isChecked ->
                        if (isChecked) {
                            binding.check.isChecked = false
                            binding.check1.isChecked = false
                            binding.check2.isChecked = false
                            binding.check3.isChecked = false
                            binding.check4.isChecked = false
                            binding.check5.setTextColor(
                                ContextCompat.getColor(
                                    this@Meeting,
                                    R.color.blue
                                )
                            )
                        } else {
                            binding.check5.setTextColor(
                                ContextCompat.getColor(
                                    this@Meeting,
                                    R.color.white
                                )
                            )
                        }
                    }

                    val checkBoxIds = listOf(
                        binding.check,
                        binding.check1,
                        binding.check2,
                        binding.check3,
                        binding.check4
                    )

                    for (checkBoxId in checkBoxIds) {

                        checkBoxId.setOnCheckedChangeListener { _, isChecked ->
                            if (isChecked) {
                                binding.check5.isChecked = false
                            }
                        }
                    }
                }

                6 -> {
                    binding.imageView5.setOnClickListener {
                        howManyClick -= 2
                        binding.button9.performClick()
                    }
                    binding.progressBar2.progress = 80
                    binding.checktapok.visibility = View.GONE
                    val reasons = mutableListOf<String>()
                    val checkBoxes = listOf(
                        binding.check,
                        binding.check1,
                        binding.check2,
                        binding.check3,
                        binding.check4,
                        binding.check5
                    )

                    for (checkBox in checkBoxes) {
                        val reasonText = checkBox.text.toString()
                        if (checkBox.isChecked) {
                            reasons.add(reasonText)
                        }
                    }

                    if (reasons.size == 1) {
                        when (reasons[0]) {
                            getString(R.string.boost_my_career) -> binding.textView7.text =
                                "Let's open new horizons! "

                            getString(R.string.connect_with_people) -> binding.textView7.text =
                                "Let's get you ready\n to communicate!"

                            getString(R.string.just_for_fun) -> binding.textView7.text =
                                "Hooray! Fun is my forte!"

                            getString(R.string.other) -> binding.textView7.text =
                                "Any reason is a good\nreason to learn!"

                            getString(R.string.prepare_for_travel) -> binding.textView7.text =
                                "This is the best way\n to prepare for future travels!"

                            getString(R.string.support_my_education) -> binding.textView7.text =
                                "Ley's ace those tests"
                        }
                    } else {
                        binding.textView7.text = "Those all great\n reasons to learn!"
                    }
                    binding.imageView5.setOnClickListener {
                        howManyClick -= 2
                        binding.button9.performClick()
                    }
                }

                7 -> {
                    binding.imageView5.setOnClickListener {
                        howManyClick -= 3
                        binding.button9.performClick()
                    }
                    howManyClick--
                    Toast.makeText(this, "Please turn on notification", Toast.LENGTH_SHORT).show()
                    binding.imageView6.visibility = View.VISIBLE
                    timer = Timer()
                    delay = 25
                    autoTypeText = "I will remind you to\n practise so it becomes\n a habit!"
                    startAutoTypeText()
                    val notificationPermissionDialog = NotificationPermissionDialog(this)
                    binding.imageView6.setOnClickListener {
                        notificationPermissionDialog.show()
                        howManyClick++
                    }


                }

                8 -> {
                    binding.imageView5.setOnClickListener {
                        howManyClick -= 2
                        binding.button9.performClick()
                    }
                    binding.progressBar2.progress = 100
                    binding.imageView6.visibility = View.GONE
                    timer = Timer()
                    delay = 25
                    autoTypeText = "Everything is ready,\n let's start the first lesson!"
                    startAutoTypeText()
                }

                9 -> {
                    val sharedPreferences =
                        getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("meet", "yes")
                    editor.apply()
                    val language = sharedPreferences.getString("language", "Нет сохраненного текста")
                    val i = Intent(this, TaskActivity::class.java)
                    val complexTask = ComplexTaskData(
                        listOf(1, 6, 2),
                        if (language == getString(R.string.english)) audioTaskData1 else  audioTaskData2ru ,
                        if (language == getString(R.string.kazak_language)) wordsList1kz else wordsList1,
                        if (language == getString(R.string.english)) grammarTaskDataPresent1 else if (language == getString(R.string.russian))grammarTaskDataPresent1ru else grammarTaskDataPresent1kz,
                        if (language == getString(R.string.english)) theoryTaskPresent else if (language == getString(R.string.russian)) theoryTaskPresentru else theoryTaskPresentkz,
                        if (language == getString(R.string.english)) textTask1 else textTask1ru,
                        if (language == getString(R.string.english)) writingTask1 else  writingTask2ru
                    )
                    i.putExtra("complex_task_data", complexTask)
                    startActivity(i)
                }

            }

        }
    }

    private fun startAutoTypeText() {
        var index = 0
        timer.scheduleAtFixedRate(timerTask {
            runOnUiThread {
                if (index < autoTypeText.length) {
                    val currentText = autoTypeText.substring(0, index + 1)
                    binding.textView7.text = currentText
                    index++
                } else {
                    timer.cancel()
                }
            }
        }, delay, delay)
    }
}

