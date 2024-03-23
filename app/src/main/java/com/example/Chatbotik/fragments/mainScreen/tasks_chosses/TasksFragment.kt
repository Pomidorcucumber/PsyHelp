package com.example.Chatbotik.fragments.mainScreen.tasks_chosses


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
    private val audioTaskData2 = AudioTaskData(
        4, listOf(
            Pair(
                R.raw.hanna, Pair(
                    "What is the problem of Hanna?",
                    Pair(listOf("Headache", "Job", "Family", "No problem"), "Headache")),
                Pair(
                    "What is the problem of Hanna?",
                    Pair(listOf("Headache", "Job", "Family", "No problem"), "Headache")
                )
                   Pair(
                        "How many pills does Hanna need?",
                Pair(listOf("3", "2", "4", "1"), "2")
            ), Pair(
                R.raw.girl, Pair(
                    "Boy's family was...",
                    Pair(listOf("Rich", "Poor", "Big", "Small"), "Poor")
                )
                        Pair(
                        "Where did children play?",
                Pair(listOf("School", "House", "Park", "Garden"), "Garden")
            )
        )))

    private val audioTaskData2ru = AudioTaskData(
        4, listOf(
            Pair(
                R.raw.earth, Pair("Название деревни:", Pair(listOf("Оймякон", "Целовка", "Долинка", "Минон"), "Оймякон"))
                        Pair("Какие люди там живут?", Pair(listOf("Веселые", "Грустные", "Странные", "Молчаливые"), "Веселые"))
        ), Pair(
            R.raw.maslenica, Pair(
                "В какой день недели катаются на санках?",
                Pair(listOf("Вторник", "Понедельник", "Четверг", "Суббота"), "Четверг")
            ), Pair(
                R.raw.banya, Pair(
                    "Самое главное в бане?",
                    Pair(listOf("Температура", "Друзья", "Еда", "Веник"), "Веник")
                )
                        Pair(
                        "Какая вода в бассейне в бане?",
                Pair(listOf("Теплая", "Холодная", "В бане нет бассейна", "Нет правильного ответа"), "Холодная")
            )
        )
    )
    ) )

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
    private val grammarTaskDataPresent2 = GrammarTaskData(
        3, listOf(
            Pair(Pair("Alice (to have) a sister.", "haves"), R.drawable.situation),
            Pair(Pair("Her sister’s name (to be) Ann.", "is"), R.drawable.situation),
            Pair(Pair("Ann (to be) a student.", "is"), R.drawable.situation),
            Pair(Pair("She (to get) up at seven o'clock.", "gets"), R.drawable.situation),
            Pair(Pair("She (to go) to the institute in the morning.", "goes"), R.drawable.situation)
        )
    )
    private val grammarTaskDataPresent2ru = GrammarTaskData(
        3, listOf(
            Pair(Pair("Он (любить) кушать овощи.", "любит"), R.drawable.situation),
            Pair(Pair("Мы (заниматься) спортом.", "занимаюсь"), R.drawable.situation),
            Pair(Pair("Она (пить) таблетки ежедневно.", "пьет"), R.drawable.situation),
            Pair(Pair("Я (работать) учителем.", "работаю"), R.drawable.situation),
            Pair(Pair("Вы (учиться) в университете.", "учитесь"), R.drawable.situation)
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
    private val grammarTaskDataPresent3ru = GrammarTaskData(
        3, listOf(
            Pair(
                Pair("Мой рабочий день (начинаться) в 8 часов.", "начинается"), R.drawable.situation
            ),
            Pair(
                Pair(
                    "Я (выключать) телевизор после того, как (почистить) зубы.",
                    "выключаю, почищу"
                ), R.drawable.situation
            ),
            Pair(Pair("Это (занять) 20 минут", "займет"), R.drawable.situation),
            Pair(Pair("Я (предпочитать) горячий завтрак.", "предпочитаю"), R.drawable.situation),
            Pair(Pair("Я (уходить) с дома поздно вечером.", "ухожу"), R.drawable.situation)
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
    private val grammarTaskDataPast1ru = GrammarTaskData(
        3, listOf(
            Pair(Pair("Я (выполнять) задание вчера вечером.", "выполнил"), R.drawable.situation),
            Pair(Pair("Она (спать) 8 часов в субботу.", "спала"), R.drawable.situation),
            Pair(Pair("Они (пить) чай каждое утро.", "пили"), R.drawable.situation),
            Pair(Pair("Он (работать) 8 часов.", "работал"), R.drawable.situation),
            Pair(Pair("У нас (быть) перерыв.", "был"), R.drawable.situation)
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
    private val grammarTaskDataPast2ru = GrammarTaskData(
        3, listOf(
            Pair(Pair(" У Алисы (быть) сестра", "была"), R.drawable.situation),
            Pair(Pair("Его сестру (звать) Аня.", "звали"), R.drawable.situation),
            Pair(Pair("Они (смеяться) над ним.", "смеялись"), R.drawable.situation),
            Pair(Pair("Она (встать) в 12:00.", "встала"), R.drawable.situation),
            Pair(Pair("Я (пропустить) первый урок.", "пропустил"), R.drawable.situation)
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
    private val grammarTaskDataFuture1ru = GrammarTaskData(
        3, listOf(
            Pair(Pair("Я (выполнить) задание до понедельника.", "выполню"), R.drawable.situation),
            Pair(Pair("Она (лечь) спать пораньше.", "ляжет"), R.drawable.situation),
            Pair(Pair("Они (пить) чай завтра.", "выпьют"), R.drawable.situation),
            Pair(Pair("Он (быть) работать учителем.", "будет"), R.drawable.situation),
            Pair(Pair("Мы (сбежать) с дома.", "сбежим"), R.drawable.situation)
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
    private val grammarTaskDataFuture2ru = GrammarTaskData(
        3, listOf(
            Pair(Pair("У Алисы (быть) сестра", "будет"), R.drawable.situation),
            Pair(Pair("Ребенка (назвать) Анна.", "назовут"), R.drawable.situation),
            Pair(Pair("Он (быть) студентом.", "будет"), R.drawable.situation),
            Pair(Pair("Она (встать) завтра утром.", "встанет"), R.drawable.situation),
            Pair(
                Pair("Она (поступить) в университет.", "поступит"),
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
    private val grammarTaskDataFuture3ru = GrammarTaskData(
        3, listOf(
            Pair(
                Pair("Мой рабочий день (начаться) через 2 минуты.", "начнется"),
                R.drawable.situation
            ),
            Pair(
                Pair(
                    "Я (почистить) зубы, а потом (выключить) телевизор.",
                    "почищу, выключу"
                ), R.drawable.situation
            ),
            Pair(Pair("Это (занять) 5 минут.", "займет"), R.drawable.situation),
            Pair(
                Pair("У него (быть) завтрак в пятницу.", "будет"), R.drawable.situation
            ),
            Pair(Pair("Я (уехать) домой скоро.", "уеду"), R.drawable.situation)
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
    private val grammarTaskDataPast3ru = GrammarTaskData(
        3, listOf(
            Pair(
                Pair("Мой рабочий день уже (начаться).", "начался"), R.drawable.situation
            ),
            Pair(
                Pair(
                    "Я (почистить) свои зубы, а потом (выключить) телевизор.", "почистил, выключил"
                ), R.drawable.situation
            ),
            Pair(Pair("Это (занять) 2 часа.", "заняло"), R.drawable.situation),
            Pair(Pair("Я (позавтракать) очень поздно.", "позавтракал"), R.drawable.situation),
            Pair(Pair("Она (уехать) домой в 7.", "уехала"), R.drawable.situation)
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
    private val theoryTaskPresentru = GrammarTheoryData(
        4, listOf(
            "The present tense in Russian refers to actions or states that are happening in the present moment.\n"  + "It is used to talk about routines, habits, general truths, and actions happening at the present time.\n" + "To form the present tense, we typically use verb conjugation, which means that the verb changes its ending depending on the subject of the sentence.\n" +"For example:\n" + "\n" + "Он сейчас спит. – He is sleeping now.\n" + "\n" + "Я все ещё готовлю обед. – I am still cooking lunch.")
    )
    private val theoryTaskPast = GrammarTheoryData(
        4, listOf(
            "Past Simple - простое прошедшее время\n" + "Время Past Simple используется для обозначения действия, которое произошло в определенное время в прошлом и время совершения которого уже истекло.\n" + "Для уточнения момента совершения действия в прошлом при использовании времени Past Simple обычно используются такие слова, как: \n" + "five days ago – пять дней назад; last year – в прошлом году; yesterday – вчера; \n" + "Образование Past Simple\n" + "Утвердительные предложения:\n" + "I played  We played.   You played.  You played.  He / she / it played.  They played.\n" + "Вопросительные предложения:\n" + "Did I play?\tDid we play?  Did you play?  Did you play?  Did he / she / it play?\t Did they play?\n" + "Отрицательные предложения:\n" + "I did not play.  We did not play.  You did not play.  You did not play.  He / she / it did not play.  They did not play.\n"
        )
    )
    private val theoryTaskPastru = GrammarTheoryData(
        4, listOf(
            "The past tense in Russian, like any language, is one of the most important things to learn.\n" + "The past tense allows you tell stories, and discuss events that have already happened.\n" + "Forming the past tense verbs in Russian is actually quite easy.\n" + "In fact it is one of the simplest conjugations to remember in Russian.\n"+"Я знал - I knew (man speaking)\n" +
                    "\n" +
                    "Я знала - I knew (woman speaking)\n" +
                    "\n" +
                    "Он знал - He knew\n" +
                    "\n" +
                    "Она знала - She knew\n" +
                    "\n" +
                    "Оно знало - It knew" )
    )
    private val theoryTaskFuture = GrammarTheoryData(
        4, listOf(
            "Future Simple - простое будущее время\n" + "    Время Future Simple ссылается на действие, которое совершится в неопределенном или отдаленном будущем.\n" + "    Простое будущее время в английском языке обычно используется с обстоятельствами:\n" + "    next year – в следующем году; in five years – через пять лет; in 2095 – в 2095 году\n" + "\n" + "    Образование Future Simple\n" + "\n" + "    Утвердительные предложения:\n" + "    I will play.  We will play.  You will play.  You will play.  He / she / it will play.  They will play.\n" + "    Вопросительные предложения:\n" + "    Will I play?\tWill we play?  Will you play?  Will you play?  Will he / she / it play?  Will they play?\n" + "    Отрицательные предложения:\n" + "    I will not play.  We will not play.  You will not play.\tYou will not play.  He / she / it will not play.  They will not play.\n"
        )
    )
    private val theoryTaskFutureru = GrammarTheoryData(
        4, listOf(
            "Russian future tense can have two forms: simple (via adding personal endings to verbs of perfective aspect), and compound (via using the verb “to be” in the future tense + the infinitive)." + "Я сделаю домашнее задание завтра (Future Simple Tense in Russian) =\n" +
                    "\n" +
                    "I will do (finish) my homework tomorrow (Future Simple Tense in English)")
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
    private val textTask2 = TextTaskData(
        1,
        "I come from a strange family. My parents have always believed that we should learn to look after ourselves from an early age. That included holidays. I remember my poor brother went on a canoeing trip on the River Thames with a cousin when they were both just twelve years old. They had a miserable time and have never really recovered from the experience. When I was fifteen, they decided I was old enough to go on holiday with just my best friend. ‘You’re going to hitch-hike to the Lake District with a tent and a backpack; you’re going to camp, up in the mountains, for a week; and then – if you’re still alive – you’re going to hitch-hike back again. ‘So we hitch-hiked for hundreds of kilometres, we camped, we got cold and wet and scared, and couldn’t afford to buy enough food. But, against the odds, we survived.",
        listOf(
            Pair(
                "Canoening was at the River...",
                Pair(listOf("Thames", "Black", "Themez", "Thomas"), "Wake up")
            ), Pair(
                "We walked ... of kilometres",
                Pair(listOf("10", "1000", "100", "50"), "100")
            ), Pair(
                "I come from a ... family", Pair(
                    listOf("Funny", "Scary", "Strange", "Sad"),
                    "Strange"
                )
            )
        )
    )
    private val textTask2ru = TextTaskData(
        1,
        "Стоит на лесной опушке берёза. Дятел пробил в коре дырочку. Он напился берёзового сока и улетел. Побежал ручеёк по стволу дерева. Чистые крупные капли сока упали на землю.\n" +
                "Прилетели синицы. Закружились вокруг берёзы бабочки. Пришли и рыжие муравьи.\n" +
                "Всех угостила вкусным соком добрая берёза.",
        listOf(
            Pair(
                "Что стояло на опушке?",
                Pair(listOf("Клен", "Береза", "Дуб", "Сосна"), "Береза")
            ), Pair(
                "Кто пробил дырочку в коре?",
                Pair(listOf("Дятел", "Стрекоза", "Медведь", "Белка"), "Дятел")
            ), Pair(
                "Кто прилетел в конце?", Pair(
                    listOf("Дятлы", "Голуби", "Синицы", "Воробьи"),
                    "Синицы"
                )
            ) )
    )

    private val writingTask1 = WritingTaskData(6, listOf("Семья"))
    private val writingTask2ru = WritingTaskData(6, listOf("Family"))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewTasks
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
            Task("Задание 6", R.drawable.dictionary_icon)
        )

        adapter = TasksAdapter(tasks)
        recyclerView.adapter = adapter
        binding.buttonWithImageAndText.setOnClickListener {
            val i = Intent(requireContext(), TaskActivity::class.java)
            val complexTask = ComplexTaskData(
                listOf(1, 2, 3, 4, 5, 6),
                audioTaskData1,
                wordsList1,
                grammarTaskDataPresent1,
                theoryTaskPresent,
                textTask1,
                writingTask1
            )
            i.putExtra("complex_task_data", complexTask)
            startActivity(i)
        }
        return binding.root
    }
}
